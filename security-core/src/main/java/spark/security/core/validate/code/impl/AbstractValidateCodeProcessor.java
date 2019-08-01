package spark.security.core.validate.code.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import spark.security.core.validate.code.ValidateCode;
import spark.security.core.validate.code.ValidateCodeGenerator;
import spark.security.core.validate.code.ValidateCodeProcessor;

import java.util.Map;

/**
 * @ClassName AbstractValidateCodeProcessor
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:29 PM
 * @Version 1.0
 **/
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request,
                SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(), validateCode);
    }

    private String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }

    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;
}
