package spark.exception;

/**
 * @ClassName UserNotExistException
 * @Description TODO
 * @Author Spark
 * @Date 7/26/2019 5:17 PM
 * @Version 1.0
 **/
public class UserNotExistException extends RuntimeException{

    private static final long serialVersionUID = -6112780192479692859L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
