package spark.validator;

import org.springframework.beans.factory.annotation.Autowired;
import spark.service.HelloService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName MyConstraintValidator
 * @Description 不要Component注解
 * @Author Spark
 * @Date 7/26/2019 4:05 PM
 * @Version 1.0
 **/
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("My validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("Tom");
        System.out.println(value);
        return true;
    }
}
