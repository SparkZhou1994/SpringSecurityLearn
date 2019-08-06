package spark.security.core.social.weixin.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import spark.security.core.social.weixin.api.Weixin;
import spark.security.core.social.weixin.api.WeixinUserInfo;

/**
 * @ClassName WeixinAdapter
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 7:49 PM
 * @Version 1.0
 **/
public class WeixinAdapter implements ApiAdapter<Weixin> {

    private String openId;

    public WeixinAdapter() {}

    public WeixinAdapter(String openId){
        this.openId = openId;
    }

    @Override
    public boolean test(Weixin weixin) {
        return true;
    }

    @Override
    public void setConnectionValues(Weixin api, ConnectionValues values) {
        WeixinUserInfo profile = api.getUserInfo(openId);
        values.setProviderUserId(profile.getOpenid());
        values.setDisplayName(profile.getNickname());
        values.setImageUrl(profile.getHeadimgurl());
    }

    @Override
    public UserProfile fetchUserProfile(Weixin weixin) {
        return null;
    }

    @Override
    public void updateStatus(Weixin weixin, String s) {

    }
}
