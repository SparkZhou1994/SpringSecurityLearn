package spark.security.core.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;
import spark.security.core.properties.SecurityProperties;
import spark.security.core.properties.SocialProperties;

import javax.sql.DataSource;
import javax.xml.ws.Action;

/**
 * @ClassName SocialConfig
 * @Description TODO
 * @Author Spark
 * @Date 8/4/2019 10:56 AM
 * @Version 1.0
 **/
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("spark_");
        return repository;
    }

    @Bean
    public SpringSocialConfigurer sparkSocialConfig() {
        String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
        SparkSpringSocialConfigurer configurer = new SparkSpringSocialConfigurer(filterProcessesUrl);
        return configurer;
    }
}
