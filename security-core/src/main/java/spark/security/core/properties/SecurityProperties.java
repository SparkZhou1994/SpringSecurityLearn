package spark.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SecurityProperties
 * @Description TODO
 * @Author Spark
 * @Date 7/30/2019 2:21 PM
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "spark.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
