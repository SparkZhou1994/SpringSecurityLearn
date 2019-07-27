package spark.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName TimeAspect
 * @Description TODO
 * @Author Spark
 * @Date 7/26/2019 10:59 PM
 * @Version 1.0
 **/
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* spark.web.controller.UserController.*(..))")
    public Object  handeControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Time aspect start");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("Arg is: " + arg);
        }
        Long start = new Date().getTime();
        Object object = pjp.proceed();
        System.out.println("Time aspect 耗时: " + (new Date().getTime() - start));
        System.out.println("Time aspect end");
        return null;
    }
}
