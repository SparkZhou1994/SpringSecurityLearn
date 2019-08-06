package spark.security.core.social.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @ClassName WeixinImpl
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 7:39 PM
 * @Version 1.0
 **/
public class WeixinImpl extends AbstractOAuth2ApiBinding implements Weixin{

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

    public WeixinImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }

    @Override
    public WeixinUserInfo getUserInfo(String openId) {
        String url = URL_GET_USER_INFO + openId;
        String response = getRestTemplate().getForObject(url, String.class);
        if(StringUtils.contains(response, "errcode")) {
            return null;
        }
        WeixinUserInfo profile = null;
        try {
            profile = objectMapper.readValue(response, WeixinUserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }
}
