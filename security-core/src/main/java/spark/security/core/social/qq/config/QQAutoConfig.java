package spark.security.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import spark.security.core.properties.QQProperties;
import spark.security.core.properties.SecurityProperties;
import spark.security.core.social.qq.api.QQ;
import spark.security.core.social.qq.connect.QQConnectionFactory;

/**
 * @ClassName QQAutoConfig
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 4:48 PM
 * @Version 1.0
 **/
@Configuration
@ConditionalOnProperty(prefix = "spark.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }
}
