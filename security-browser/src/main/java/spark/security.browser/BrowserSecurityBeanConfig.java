package spark.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import spark.security.browser.logout.SparkLogoutSuccessHandler;
import spark.security.browser.session.SparkExpiredSessionStrategy;
import spark.security.browser.session.SparkInvalidSessionStrategy;
import spark.security.core.properties.SecurityProperties;

/**
 * @ClassName BrowserSecurityBeanConfig
 * @Description TODO
 * @Author Spark
 * @Date 8/7/2019 12:14 AM
 * @Version 1.0
 **/
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new SparkInvalidSessionStrategy(securityProperties);
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new SparkExpiredSessionStrategy(securityProperties);
    }

    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new SparkLogoutSuccessHandler(securityProperties.getBrowser().getSignOutUrl());
    }
}
