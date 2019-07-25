package spark.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @ClassName User
 * @Description TODO
 * @Author Spark
 * @Date 7/25/2019 12:22 AM
 * @Version 1.0
 **/
public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView{};

    private String username;

    private String password;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
