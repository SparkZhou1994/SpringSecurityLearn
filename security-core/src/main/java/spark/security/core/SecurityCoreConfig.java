package spark.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import spark.security.core.properties.SecurityProperties;

/**
 * @ClassName SecurityCoreConfig
 * @Description TODO
 * @Author Spark
 * @Date 7/30/2019 2:25 PM
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
