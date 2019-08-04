package spark.security.core.social.qq.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import spark.security.core.social.qq.api.QQ;

/**
 * @ClassName QQConnectionFactory
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 10:51 AM
 * @Version 1.0
 **/
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
