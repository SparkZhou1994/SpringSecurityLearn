package spark.security.core.social.weixin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;
import spark.security.core.properties.SecurityProperties;
import spark.security.core.properties.WeixinProperties;
import spark.security.core.social.weixin.SparkConnectView;
import spark.security.core.social.weixin.connect.WeixinConnectionFactory;

/**
 * @ClassName WeixinAutoConfiguration
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 10:24 PM
 * @Version 1.0
 **/
@Configuration
@ConditionalOnProperty(prefix = "spark.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
        return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
                weixinConfig.getAppSecret());
    }

    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new SparkConnectView();
    }
}
