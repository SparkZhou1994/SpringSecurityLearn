package spark.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import spark.security.app.social.AppSignUpUtils;
import spark.security.core.support.SocialUserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AppSecurityController
 * @Description TODO
 * @Author Spark
 * @Date 8/10/2019 9:06 PM
 * @Version 1.0
 **/
@RestController
public class AppSecurityController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;
    @Autowired
    private AppSignUpUtils appSignUpUtils;

    @GetMapping("/social/signUp")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadimg(connection.getImageUrl());
        appSignUpUtils.saveConnectionData(new ServletWebRequest(request),  connection.createData());
        return userInfo;
    }
}
