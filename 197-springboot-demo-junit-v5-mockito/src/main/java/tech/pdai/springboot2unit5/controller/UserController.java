package tech.pdai.springboot2unit5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot2unit5.entity.User;
import tech.pdai.springboot2unit5.service.IUserService;

import java.util.List;

/**
 * User controller.
 */
@RestController
public class UserController {

    /**
     * user service.
     */
    private final IUserService userService;

    /**
     * init.
     *
     * @param userService2 user service
     */
    public UserController(final IUserService userService2) {
        this.userService = userService2;
    }

    /**
     * find user list.
     *
     * @return list
     */
    @GetMapping("user/list")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.findAll());
    }
}
