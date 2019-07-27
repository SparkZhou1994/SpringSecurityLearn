package spark.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spark.web.filter.TimeFilter;
import spark.web.interceptor.TimeInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebConfig
 * @Description WebMvcConfigurerAdapter 是用来添加Interceptor
 * @Author Spark
 * @Date 7/26/2019 6:57 PM
 * @Version 1.0
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    // 执行顺序 : Filter > Interceptor > ControllerAdvice > Aspect > Controller
    /**
     *执行顺序（没有异常或@ExceptionHandler 处理异常）
     * 1.Filter -- doFilter
     * 2.Interceptor -- preHandle
     * 3.Aspect -- @Before
     * 4.Controller
     * 5.Aspect -- @After
     * 6.Interceptor -- postHandle
     * 7.Interceptor -- afterCompletion
     * 8.Filter -- destory
     * 其中如果是ExceptionHandler处理的异常被抛出 ,Interceptor的afterCompletion的Exception is null
     */

    /**
     * 执行顺序（有 没有ExceptionHandler处理异常 被抛出）
     * 1.Filter -- doFilter
     * 2.Interceptor -- preHandle
     * 3. Controller
     * 4.Interceptor -- afterCompletion
     * 5.Filter -- destory
     */

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    // 配置Filter无需WebMvcConfigurerAdapter
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }
}
