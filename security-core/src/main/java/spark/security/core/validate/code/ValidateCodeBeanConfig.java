package spark.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spark.security.core.properties.SecurityProperties;
import spark.security.core.validate.code.image.ImageCodeGenerator;
import spark.security.core.validate.code.sms.DefaultSmsCodeSender;
import spark.security.core.validate.code.sms.SmsCodeSender;

/**
 * @ClassName ValidateCodeBeanConfig
 * @Description 生成CodeGenerator类
 * @Author Spark
 * @Date 8/1/2019 1:12 AM
 * @Version 1.0
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
