package spark.security.core.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import spark.security.core.properties.SecurityConstants;

/**
 * @ClassName AbstractChannelSecurityConfig
 * @Description TODO
 * @Author Spark
 * @Date 8/2/2019 3:10 AM
 * @Version 1.0
 **/
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler sparkAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler sparkAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_IN_PROCESSING_URL_FORM )
                .successHandler(sparkAuthenticationSuccessHandler)
                .failureHandler(sparkAuthenticationFailureHandler);
    }

}
