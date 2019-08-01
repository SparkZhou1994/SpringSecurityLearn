package spark.security.core.validate.code.image;

import spark.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ClassName ImageCode
 * @Description TODO
 * @Author Spark
 * @Date 7/30/2019 4:40 PM
 * @Version 1.0
 **/
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode() {}

    public ImageCode(BufferedImage image, String code, Integer expireIn) {
        super(code, LocalDateTime.now().plusSeconds(expireIn));
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
