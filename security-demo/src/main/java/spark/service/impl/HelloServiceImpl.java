package spark.service.impl;

import org.springframework.stereotype.Service;
import spark.service.HelloService;

/**
 * @ClassName HelloServiceImpl
 * @Description TODO
 * @Author Spark
 * @Date 7/26/2019 4:09 PM
 * @Version 1.0
 **/
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("Greeting");
        return "Hello " + name;
    }
}
