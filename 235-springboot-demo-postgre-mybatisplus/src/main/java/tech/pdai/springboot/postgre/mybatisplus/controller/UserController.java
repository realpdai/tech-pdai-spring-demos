package tech.pdai.springboot.postgre.mybatisplus.controller;


import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.postgre.mybatisplus.entity.User;
import tech.pdai.springboot.postgre.mybatisplus.entity.query.UserQueryBean;
import tech.pdai.springboot.postgre.mybatisplus.entity.response.ResponseResult;
import tech.pdai.springboot.postgre.mybatisplus.service.IUserService;


/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * @param user user param
     * @return user
     */
    @ApiOperation("Add/Edit User")
    @PostMapping("add")
    public ResponseResult<User> add(User user) {
        if (user.getId() == null) {
            user.setCreateTime(LocalDateTime.now());
        }
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
        return ResponseResult.success(userService.getById(user.getId()));
    }


    /**
     * @return user list
     */
    @ApiOperation("Query User One")
    @GetMapping("edit/{userId}")
    public ResponseResult<User> edit(@PathVariable("userId") Long userId) {
        return ResponseResult.success(userService.getById(userId));
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User List")
    @GetMapping("list")
    public ResponseResult<List<User>> list(UserQueryBean userQueryBean) {
        return ResponseResult.success(userService.findList(userQueryBean));
    }
}
