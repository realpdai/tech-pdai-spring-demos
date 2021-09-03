package tech.pdai.springboot.helloworld.controller;

import com.pdai.swagger.entity.User;
import com.pdai.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public User add(User user) {
        userService.addUser(user);
        return user;
    }

    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }
}
