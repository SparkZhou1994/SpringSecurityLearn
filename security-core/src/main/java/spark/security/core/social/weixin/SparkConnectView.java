package spark.security.core.social.weixin;

import org.springframework.security.access.method.P;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName SparkConnectView
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 11:22 PM
 * @Version 1.0
 **/
public class SparkConnectView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        if (model.get("connection") == null) {
            httpServletResponse.getWriter().write("<h3>解绑成功</h3>");
        } else {
            httpServletResponse.getWriter().write("<h3>绑定成功</h3>");
        }

    }
}
