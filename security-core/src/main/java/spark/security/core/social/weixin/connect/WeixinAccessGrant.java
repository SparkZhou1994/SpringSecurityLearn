package spark.security.core.social.weixin.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * @ClassName WeixinAccessGrant
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 7:45 PM
 * @Version 1.0
 **/
public class WeixinAccessGrant extends AccessGrant {

    private static final long serialVersionUID = -7243374526633186782L;

    private String openId;

    public WeixinAccessGrant() {
        super("");
    }

    public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
