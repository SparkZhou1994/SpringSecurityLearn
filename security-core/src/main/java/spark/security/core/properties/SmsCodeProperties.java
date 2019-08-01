package spark.security.core.properties;

/**
 * @ClassName ImageCodeProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:39 AM
 * @Version 1.0
 **/
public class SmsCodeProperties {

    private Integer length = 6;

    private Integer expireIn = 60;

    private String url;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
