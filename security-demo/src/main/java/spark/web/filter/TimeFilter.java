package spark.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName TimeFilter
 * @Description 去掉Component注解 模拟第三方提供的Filter
 * @Author Spark
 * @Date 7/26/2019 5:49 PM
 * @Version 1.0
 **/
/*@Component*/
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Time filter start");
        Long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Time filter 耗时: " + (new Date().getTime() - start));
        System.out.println("Time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("Time filter destroy");
    }
}
