package spark.security.core.properties;

/**
 * @ClassName BrowserProperties
 * @Description TODO
 * @Author Spark
 * @Date 7/30/2019 2:22 PM
 * @Version 1.0
 **/
public class BrowserProperties {

    private String signUpUrl = "/signUp.html";

    private String loginPage = "/signIn.html";

    private LoginType loginType = LoginType.JSON;

    private Integer rememberMeSeconds = 3600;

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

    public Integer getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(Integer rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
