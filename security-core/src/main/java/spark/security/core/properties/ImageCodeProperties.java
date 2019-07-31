package spark.security.core.properties;

/**
 * @ClassName ImageCodeProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:39 AM
 * @Version 1.0
 **/
public class ImageCodeProperties {

    private Integer width = 67;

    private Integer height = 23;

    private Integer length = 4;

    private Integer expireIn = 60;

    private String url;


    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

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
