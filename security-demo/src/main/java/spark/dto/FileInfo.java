package spark.dto;

/**
 * @ClassName FileInfo
 * @Description TODO
 * @Author Spark
 * @Date 7/27/2019 9:39 AM
 * @Version 1.0
 **/
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
