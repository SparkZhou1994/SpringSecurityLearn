package spark.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;
import spark.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import spark.security.core.authentication.mobile.SmsCodeAuthenticationSeucurityConfig;
import spark.security.core.properties.SecurityConstants;
import spark.security.core.properties.SecurityProperties;
import spark.security.core.validate.code.ValidateCodeSecurityConfig;

/**
 * @ClassName SparkResourceServerConfig
 * @Description TODO
 * @Author Spark
 * @Date 8/7/2019 8:43 PM
 * @Version 1.0
 **/
@Configuration
@EnableResourceServer
public class SparkResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler sparkAuthenticationSuccessHandler;
    @Autowired
    protected AuthenticationFailureHandler sparkAuthenticationFailureHandler;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;
    @Autowired
    private SpringSocialConfigurer sparkSocialConfig;
    @Autowired
    private SmsCodeAuthenticationSeucurityConfig smsCodeAuthenticationSeucurityConfig;
    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_IN_PROCESSING_URL_FORM )
                .successHandler(sparkAuthenticationSuccessHandler)
                .failureHandler(sparkAuthenticationFailureHandler);
        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSeucurityConfig)
                .and()
                .apply(sparkSocialConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_IN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        securityProperties.getBrowser().getSignOutUrl(),
                        "/user/regist","/session/invalid")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
