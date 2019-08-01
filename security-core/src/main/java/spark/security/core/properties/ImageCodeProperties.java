package spark.security.core.properties;

import spark.security.core.validate.code.sms.SmsCodeSender;

/**
 * @ClassName ImageCodeProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:39 AM
 * @Version 1.0
 **/
public class ImageCodeProperties extends SmsCodeProperties {

    private Integer width = 67;

    private Integer height = 23;

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

    public ImageCodeProperties() {
        setLength(4);
    }
}
