package spark.security.browser.support;

/**
 * @ClassName SimpleResponse
 * @Description TODO
 * @Author Spark
 * @Date 7/30/2019 12:13 PM
 * @Version 1.0
 **/
public class SimpleResponse {
    private Object content;

    public SimpleResponse() {

    }

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
