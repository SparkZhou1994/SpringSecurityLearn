package spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName DemoApplication
 * @Description localhost:6080:/swagger-ui.html 打开swagger
 * @Author Spark
 * @Date 7/24/2019 11:45 PM
 * @Version 1.0
 **/
@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
