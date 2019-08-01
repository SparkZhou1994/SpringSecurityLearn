package spark.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeRepository
 * @Description TODO
 * @Author Spark
 * @Date 8/2/2019 2:09 AM
 * @Version 1.0
 **/
public interface ValidateCodeRepository {

    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

    ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

    void remove(ServletWebRequest request, ValidateCodeType codeType);
}
