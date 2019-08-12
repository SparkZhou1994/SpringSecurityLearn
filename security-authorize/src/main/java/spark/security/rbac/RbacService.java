package spark.security.rbac;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RbacService
 * @Description TODO
 * @Author Spark
 * @Date 8/12/2019 7:04 PM
 * @Version 1.0
 **/
public interface RbacService {

    Boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
