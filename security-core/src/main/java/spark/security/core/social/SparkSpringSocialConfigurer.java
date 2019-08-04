package spark.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName SparkSpringSocialConfigurer
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 5:26 PM
 * @Version 1.0
 **/
public class SparkSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public SparkSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}
