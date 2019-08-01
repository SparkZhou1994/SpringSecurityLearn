package spark.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeProcessor
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:27 PM
 * @Version 1.0
 **/
public interface ValidateCodeProcessor {

    void create(ServletWebRequest request) throws Exception;

    void validate(ServletWebRequest servletWebRequest);
}
