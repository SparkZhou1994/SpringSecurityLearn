package spark.security.core.social.qq.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import spark.security.core.social.qq.api.QQ;
import spark.security.core.social.qq.api.QQUserInfo;

/**
 * @ClassName QQAdapter
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 2:05 AM
 * @Version 1.0
 **/
public class QQAdapter implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues connectionValues) {
        QQUserInfo userInfo = api.getUserInfo();
        connectionValues.setDisplayName(userInfo.getNickname());
        connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());
        connectionValues.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
