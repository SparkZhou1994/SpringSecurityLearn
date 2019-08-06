package spark.security.browser.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;
import spark.security.browser.support.SimpleResponse;
import spark.security.core.properties.SecurityProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AbstractSessionStrategy
 * @Description TODO
 * @Author Spark
 * @Date 8/7/2019 12:10 AM
 * @Version 1.0
 **/
public class AbstractSessionStrategy {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String destinationUrl;

    private SecurityProperties securityPropertie;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private boolean createNewSession = true;

    private ObjectMapper objectMapper = new ObjectMapper();

    public AbstractSessionStrategy(SecurityProperties securityPropertie) {
        String invalidSessionUrl = securityPropertie.getBrowser().getSession().getSessionInvalidUrl();
        Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl), "url must start with '/' or with 'http(s)'");
        Assert.isTrue(StringUtils.endsWithIgnoreCase(invalidSessionUrl, ".html"), "url must end with '.html'");
        this.destinationUrl = invalidSessionUrl;
        this.securityPropertie = securityPropertie;
    }

    protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("session失效");
        if (createNewSession) {
            request.getSession();
        }
        String sourceUrl = request.getRequestURI();
        String targetUrl;
        if (StringUtils.endsWithIgnoreCase(sourceUrl, ".html")) {
            if(StringUtils.equals(sourceUrl, securityPropertie.getBrowser().getSignInPage())
                    || StringUtils.equals(sourceUrl, securityPropertie.getBrowser().getSignOutUrl())){
                targetUrl = sourceUrl;
            }else{
                targetUrl = destinationUrl;
            }
            logger.info("跳转到:"+targetUrl);
            redirectStrategy.sendRedirect(request, response, targetUrl);
        } else {
            Object result = buildResponseContent(request);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(result));
        }
    }

    /**
     * @param request
     * @return
     */
    protected Object buildResponseContent(HttpServletRequest request) {
        String message = "session已失效";
        if (isConcurrency()) {
            message = message + "，有可能是并发登录导致的";
        }
        return new SimpleResponse(message);
    }

    protected boolean isConcurrency() {
        return false;
    }

    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }
}
