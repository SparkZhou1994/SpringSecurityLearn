package spark.security.app;

/**
 * @ClassName AppSecretException
 * @Description TODO
 * @Author Spark
 * @Date 8/10/2019 8:56 PM
 * @Version 1.0
 **/
public class AppSecretException extends RuntimeException {

    private static final long serialVersionUID = -1629364510827838114L;

    public AppSecretException(String msg){
        super(msg);
    }
}
