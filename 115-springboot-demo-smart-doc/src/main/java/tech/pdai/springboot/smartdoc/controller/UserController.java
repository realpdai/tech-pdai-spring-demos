package tech.pdai.springboot.smartdoc.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.smartdoc.entity.ResponseResult;
import tech.pdai.springboot.smartdoc.entity.param.UserParam;
import tech.pdai.springboot.smartdoc.entity.vo.AddressVo;
import tech.pdai.springboot.smartdoc.entity.vo.UserVo;

/**
 * User API.
 *
 * @author pdai
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Add user.
     *
     * @param userParam user param
     * @return user
     */
    @PostMapping("add")
    public ResponseResult<String> add(@RequestBody UserParam userParam) {
        return ResponseResult.success("success");
    }

    /**
     * User list.
     *
     * @return user list
     * @since 1.2
     */
    @GetMapping("list")
    public ResponseResult<List<UserVo>> list() {
        List<UserVo> userVoList = Collections.singletonList(UserVo.builder().name("dai").age(18)
                .address(AddressVo.builder().city("SZ").zipcode("10001").build()).build());
        return ResponseResult.success(userVoList);
    }
}
