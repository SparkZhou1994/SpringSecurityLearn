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

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social = new SocialProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }
}
