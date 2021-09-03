package tech.pdai.springboot.swagger.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.swagger.entity.User;
import tech.pdai.springboot.swagger.entity.param.UserParam;
import tech.pdai.springboot.swagger.service.UserService;

/**
 * @author pdai
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/user/add .
     *
     * @param userParam user param
     * @return user
     */
    @ApiOperation("Add User")
    @RequestMapping("add")
    public User add(@RequestBody UserParam userParam) {
        userService.addUser(user);
        return user;
    }

    /**
     * http://localhost:8080/user/list .
     *
     * @return user list
     */
    @ApiOperation("Query User List")
    @ApiResponse(responseCode = "1001", description = "操作成功")
    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "信息id", required = true)
    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }
}
