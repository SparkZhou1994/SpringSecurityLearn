package spark.security.core.validate.code.sms;

/**
 * @ClassName SmsCodeSender
 * @Description TODO
 * @Author Spark
 * @Date 8/1/2019 12:01 PM
 * @Version 1.0
 **/
public interface SmsCodeSender {

    void send(String mobile, String code);
}
