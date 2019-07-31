package spark.security.core.properties;

/**
 * @ClassName ValidateCodeProperties
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:41 AM
 * @Version 1.0
 **/
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
