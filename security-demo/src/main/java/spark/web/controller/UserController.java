package spark.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import spark.dto.User;
import spark.dto.UserQueryCondition;
import sun.misc.UCDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Spark
 * @Date 7/25/2019 12:20 AM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/withParam")
    public List<User> queryWithParam(@RequestParam(name = "username", required = false, defaultValue = "Spark") String nickname) {
        System.out.println(nickname);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return null;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2, size = 7, sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return null;
    }

    //\\d+ 正则表示只接受数字
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id", required = true) String id) {
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
