package tech.pdai.springboot.mapstruct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.mapstruct.entity.param.UserQueryParam;
import tech.pdai.springboot.mapstruct.entity.vo.UserVo;
import tech.pdai.springboot.mapstruct.entity.vo.UserWithAddressVo;
import tech.pdai.springboot.mapstruct.service.IUserService;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("list")
    public List<UserVo> list(UserQueryParam userParam) {
        return userService.userList(userParam);
    }

    @GetMapping("bind")
    public UserWithAddressVo bind(UserQueryParam userParam) {
        return userService.bindAddressTest(userParam);
    }

}
