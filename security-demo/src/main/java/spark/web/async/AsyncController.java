package spark.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @ClassName AsyncController
 * @Description TODO
 * @Author Spark
 * @Date 7/27/2019 10:07 PM
 * @Version 1.0
 **/
@RestController
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/orderSync")
    public String orderSync() throws InterruptedException {
        logger.info("主线程开始");
        Thread .sleep(1000);
        logger.info("主线程返回");
        return "success";
    }

    @RequestMapping("/orderAsyncRunnable")
    public Callable<String> orderAsyncRunnable() throws InterruptedException {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始");
                Thread.sleep(1000);
                System.out.println("副线程返回");
                return "success";
            }
        };
        logger.info("主线程返回");
        return result;
    }

    @RequestMapping("/orderAsync")
    public DeferredResult<String> orderAsync() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.random(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        logger.info("主线程返回");
        return result;
    }
}
