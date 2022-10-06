package tech.pdai.springboot.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pdai.springboot.helloworld.entity.User;
import tech.pdai.springboot.helloworld.service.UserService;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/user/add .
     *
     * @param user user param
     * @return user
     */
    @PostMapping("add")
    public User add(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    /**
     * http://localhost:8080/user/list .
     *
     * @return user list
     */
    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }
}
