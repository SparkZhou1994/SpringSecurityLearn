package spark.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import spark.security.core.validate.code.ImageCode;
import spark.security.core.validate.code.ValidateCodeGenerator;

/**
 * @ClassName DemoImageCodeGenerator
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 1:17 AM
 * @Version 1.0
 **/
@Component
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
