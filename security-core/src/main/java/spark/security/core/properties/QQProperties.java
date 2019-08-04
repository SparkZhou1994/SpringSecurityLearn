package spark.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @ClassName QQProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 11:25 AM
 * @Version 1.0
 **/
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
