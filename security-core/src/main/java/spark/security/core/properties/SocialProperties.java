package spark.security.core.properties;

/**
 * @ClassName SocialProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 11:26 AM
 * @Version 1.0
 **/
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeixinProperties weixin = new WeixinProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    public WeixinProperties getWeixin() {
        return weixin;
    }

    public void setWeixin(WeixinProperties weixin) {
        this.weixin = weixin;
    }
}
