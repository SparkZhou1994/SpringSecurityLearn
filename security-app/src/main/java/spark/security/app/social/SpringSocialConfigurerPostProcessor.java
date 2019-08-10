package spark.security.app.social;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import spark.security.core.properties.SecurityConstants;
import spark.security.core.social.SparkSpringSocialConfigurer;

/**
 * @ClassName SpringSocialConfigurerPostProcessor
 * @Description TODO
 * @Author Spark
 * @Date 8/10/2019 9:01 PM
 * @Version 1.0
 **/
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(StringUtils.equals(beanName, "imoocSocialSecurityConfig")){
            SparkSpringSocialConfigurer config = (SparkSpringSocialConfigurer)bean;
            config.signupUrl(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
            return config;
        }
        return bean;
    }
}
