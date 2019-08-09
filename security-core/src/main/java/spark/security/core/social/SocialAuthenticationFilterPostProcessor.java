package spark.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @ClassName SocialAuthenticationFilterPostProcessor
 * @Description TODO
 * @Author Spark
 * @Date 8/9/2019 4:56 PM
 * @Version 1.0
 **/
public interface SocialAuthenticationFilterPostProcessor {
    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
