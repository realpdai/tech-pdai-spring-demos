package tech.pdai.springboot.mysql8.mybatis.anno.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.User;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.query.UserQueryBean;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.response.ResponseResult;
import tech.pdai.springboot.mysql8.mybatis.anno.service.IUserService;

import java.util.List;

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
        if (user.getId()==null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return ResponseResult.success(userService.findById(user.getId()));
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User One")
    @GetMapping("edit/{userId}")
    public ResponseResult<User> edit(@PathVariable("userId") Long userId) {
        return ResponseResult.success(userService.findById(userId));
    }

    /**
     * @return user list 2
     */
    @ApiOperation("Query User One 2")
    @GetMapping("edit2/{userId}")
    public ResponseResult<User> edit2(@PathVariable("userId") Long userId) {
        return ResponseResult.success(userService.findById2(userId));
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User List")
    @GetMapping("list")
    public ResponseResult<List<User>> list(UserQueryBean userQueryBean) {
        return ResponseResult.success(userService.findList(userQueryBean));
    }

    @ApiOperation("Delete by id")
    @PostMapping("delete")
    public ResponseResult<Integer> delete(Long userId) {
        return ResponseResult.success(userService.deleteById(userId));
    }
}
