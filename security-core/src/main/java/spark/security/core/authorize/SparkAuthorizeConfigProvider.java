package spark.security.core.authorize;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import spark.security.core.properties.SecurityConstants;
import spark.security.core.properties.SecurityProperties;

/**
 * @ClassName SparkAuthorizeConfigProvider
 * @Description TODO
 * @Author Spark
 * @Date 8/12/2019 1:27 PM
 * @Version 1.0
 **/
@Component
@Order(Integer.MIN_VALUE)
public class SparkAuthorizeConfigProvider implements AuthorizeConfigProvider{

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
                config.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                    SecurityConstants.DEFAULT_LOGIN_IN_PROCESSING_URL_MOBILE,
                    securityProperties.getBrowser().getLoginPage(),
                    SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                    securityProperties.getBrowser().getSignUpUrl(),
                    securityProperties.getBrowser().getSignOutUrl(),
                    "/user/regist","/session/invalid")
                .permitAll();

    }
}
