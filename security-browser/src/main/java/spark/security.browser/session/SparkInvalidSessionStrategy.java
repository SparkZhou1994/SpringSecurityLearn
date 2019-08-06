package spark.security.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;
import spark.security.core.properties.SecurityProperties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName SparkInvalidSessionStrategy
 * @Description TODO
 * @Author Spark
 * @Date 8/7/2019 12:15 AM
 * @Version 1.0
 **/
public class SparkInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

    public SparkInvalidSessionStrategy(SecurityProperties securityPropertie) {
        super(securityPropertie);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        onSessionInvalid(httpServletRequest, httpServletResponse);
    }
}
