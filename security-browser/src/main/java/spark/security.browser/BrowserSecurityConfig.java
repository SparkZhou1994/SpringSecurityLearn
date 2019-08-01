package spark.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import spark.security.browser.authentication.SparkAuthenticationSuccessHandler;
import spark.security.core.authentication.mobile.SmsCodeAuthenticationSeucurityConfig;
import spark.security.core.properties.SecurityProperties;
import spark.security.core.validate.code.SmsCodeFilter;
import spark.security.core.validate.code.ValidateCodeFilter;

import javax.sql.DataSource;

/**
 * @ClassName BrowserSecurityConfig
 * @Description TODO
 * @Author Spark
 * @Date 7/29/2019 4:09 PM
 * @Version 1.0
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler sparkAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler sparkAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSeucurityConfig smsCodeAuthenticationSeucurityConfig;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        /**
         * 初始创建数据库只开启一次
         */
        /*tokenRepository.setCreateTableOnStartup(true);*/
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(sparkAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setAuthenticationFailureHandler(sparkAuthenticationFailureHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();

        /*http.httpBasic()*/
        /*http.formLogin()*/
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                    .loginPage("/signIn.html")
                    .loginProcessingUrl("/authentication/form")
                    .successHandler(sparkAuthenticationSuccessHandler)
                    .failureHandler(sparkAuthenticationFailureHandler)
                    .and()
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    .userDetailsService(userDetailsService)
                    .and()
                .authorizeRequests()
                    .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/*").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .csrf().disable()
                .apply(smsCodeAuthenticationSeucurityConfig);
    }
}
