package spark.security.core.properties;

/**
 * @ClassName OAuth2Properties
 * @Description TODO
 * @Author Spark
 * @Date 8/10/2019 9:54 PM
 * @Version 1.0
 **/
public class OAuth2Properties {

    private OAuth2ClientProperties[] clients = {};

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }
}
