package spark.security.core.validate.code.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import spark.security.core.properties.SecurityConstants;
import spark.security.core.validate.code.ValidateCode;
import spark.security.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * @ClassName SmsCodeProcessor
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:50 PM
 * @Version 1.0
 **/
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
