package spark.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import spark.security.core.authorize.AuthorizeConfigProvider;

/**
 * @ClassName DemoAuthorizeConifgProvider
 * @Description TODO
 * @Author Spark
 * @Date 8/12/2019 4:58 PM
 * @Version 1.0
 **/
@Component
@Order(Integer.MAX_VALUE)
public class DemoAuthorizeConifgProvider implements AuthorizeConfigProvider {

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.anyRequest().access("@rbacService.hasPermission(request, authentication)");
    }
}
