package spark.security.core.properties;

/**
 * @ClassName BrowserProperties
 * @Description TODO
 * @Author Spark
 * @Date 7/30/2019 2:22 PM
 * @Version 1.0
 **/
public class BrowserProperties {

    private String loginPage = "/signIn.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
