package spark.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoConnectionSignUp
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 6:59 PM
 * @Version 1.0
 **/
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        return connection.getDisplayName();
    }
}
