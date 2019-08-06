package spark.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;
/**
 * @ClassName WeixinProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 7:26 PM
 * @Version 1.0
 **/
public class WeixinProperties extends SocialProperties {

    private String providerId = "weixin";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
