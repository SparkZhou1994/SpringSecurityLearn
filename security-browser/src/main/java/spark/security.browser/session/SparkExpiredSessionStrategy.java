package spark.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import spark.security.core.properties.SecurityProperties;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName SparkExpiredSessionStrategy
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 11:53 PM
 * @Version 1.0
 **/
public class SparkExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public SparkExpiredSessionStrategy(SecurityProperties securityPropertie) {
        super(securityPropertie);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent)
            throws IOException, ServletException {
        sessionInformationExpiredEvent.getResponse().setContentType("application/json;charset=UTF-8");
        sessionInformationExpiredEvent.getResponse().getWriter().write("并发登录！");
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
