package spark.security.core.validate.code.image;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import spark.security.core.validate.code.impl.AbstractValidateCodeProcessor;

import javax.imageio.ImageIO;

/**
 * @ClassName ImageCodeProcessor
 * @Description 根据不同的验证 处理不同的Send方法
 * @Author Spark
 * @Date 8/1/2019 12:49 PM
 * @Version 1.0
 **/
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
