package spark.security.app.social.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;
import spark.security.core.social.SocialAuthenticationFilterPostProcessor;

/**
 * @ClassName AppSocialAuthenticationFilterPostProcessor
 * @Description TODO
 * @Author Spark
 * @Date 8/9/2019 5:05 PM
 * @Version 1.0
 **/
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {
    @Autowired
    private AuthenticationSuccessHandler sparkAuthenticationSuccessHandler;

    @Override
    public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
        socialAuthenticationFilter.setAuthenticationSuccessHandler(sparkAuthenticationSuccessHandler);
    }
}
