package spark.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeGenerator
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 1:06 AM
 * @Version 1.0
 **/
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
