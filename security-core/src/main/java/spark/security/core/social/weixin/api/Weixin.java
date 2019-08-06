package spark.security.core.social.weixin.api;

/**
 * @ClassName Weixin
 * @Description TODO
 * @Author Spark
 * @Date 8/6/2019 7:35 PM
 * @Version 1.0
 **/
public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);
}
