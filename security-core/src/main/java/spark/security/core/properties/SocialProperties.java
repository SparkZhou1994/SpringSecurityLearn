package spark.security.core.properties;

/**
 * @ClassName SocialProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 11:26 AM
 * @Version 1.0
 **/
public class SocialProperties {

    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
