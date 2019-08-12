package spark.security.rbac;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RbacServiceImpl
 * @Description TODO
 * @Author Spark
 * @Date 8/12/2019 7:06 PM
 * @Version 1.0
 **/
@Component("rbacService")
public class RbacServiceImpl implements RbacService{

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        Boolean hasPermission = Boolean.FALSE;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            Set<String> urls = new HashSet<>();
            for(String url : urls) {
                if(antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = Boolean.TRUE;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
