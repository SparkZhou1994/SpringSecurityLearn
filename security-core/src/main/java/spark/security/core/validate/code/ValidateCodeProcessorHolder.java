package spark.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ClassName ValidateCodeProcessorHolder
 * @Description TODO
 * @Author Spark
 * @Date 8/2/2019 1:44 AM
 * @Version 1.0
 **/
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
