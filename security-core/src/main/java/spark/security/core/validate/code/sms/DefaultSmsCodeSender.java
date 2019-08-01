package spark.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DefaultSmsCodeSender
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:02 PM
 * @Version 1.0
 **/
public class DefaultSmsCodeSender implements SmsCodeSender{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String mobile, String code) {
        logger.warn("请配置真实的短信验证码发送器(SmsCodeSender)");
        logger.info("向手机"+mobile+"发送短信验证码"+code);
    }
}
