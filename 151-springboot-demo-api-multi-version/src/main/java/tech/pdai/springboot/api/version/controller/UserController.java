package tech.pdai.springboot.api.version.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.api.version.config.version.ApiVersion;
import tech.pdai.springboot.api.version.entity.User;

/**
 * @author pdai
 */
@RestController
@RequestMapping("api/{v}/user")
public class UserController {

    @RequestMapping("get")
    public User getUser() {
        return User.builder().age(18).name("pdai, default").build();
    }

    @ApiVersion("1.0.0")
    @RequestMapping("get")
    public User getUserV1() {
        return User.builder().age(18).name("pdai, v1.0.0").build();
    }

    @ApiVersion("1.1.0")
    @RequestMapping("get")
    public User getUserV11() {
        return User.builder().age(19).name("pdai, v1.1.0").build();
    }

    @ApiVersion("1.1.2")
    @RequestMapping("get")
    public User getUserV112() {
        return User.builder().age(19).name("pdai2, v1.1.2").build();
    }
}
