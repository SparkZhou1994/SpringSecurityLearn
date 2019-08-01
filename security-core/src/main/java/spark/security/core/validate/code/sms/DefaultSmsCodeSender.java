package spark.security.core.validate.code.sms;

/**
 * @ClassName DefaultSmsCodeSender
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:02 PM
 * @Version 1.0
 **/
public class DefaultSmsCodeSender implements SmsCodeSender{

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }
}
