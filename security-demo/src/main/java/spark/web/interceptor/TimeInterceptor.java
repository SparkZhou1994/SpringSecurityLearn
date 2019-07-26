package spark.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ClassName TimeInterceptor
 * @Description Interceptor 必须有Component注解
 *                Interceptor 会拦截所有Controller 包括Spring 的 Controller
 * @Author Spark
 * @Date 7/26/2019 10:18 PM
 * @Version 1.0
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor {

    // preHandle 返回false 后续代码不执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("Pre-Handle");
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        httpServletRequest.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post-Handle");
        Long start = (Long)httpServletRequest.getAttribute("startTime");
        System.out.println("Time interceptoer 耗时: " + (new Date().getTime() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        System.out.println("After-Completion");
        Long start = (Long)httpServletRequest.getAttribute("startTime");
        System.out.println("Time interceptoer 耗时: " + (new Date().getTime() - start));
        System.out.println("Exception is: " + e);
    }
}
