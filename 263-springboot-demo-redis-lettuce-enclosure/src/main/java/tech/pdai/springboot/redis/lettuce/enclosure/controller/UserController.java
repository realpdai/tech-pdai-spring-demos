package tech.pdai.springboot.redis.lettuce.enclosure.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.redis.lettuce.enclosure.entity.User;
import tech.pdai.springboot.redis.lettuce.enclosure.entity.response.ResponseResult;
import tech.pdai.springboot.redis.lettuce.enclosure.service.IRedisService;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IRedisService<User> redisService;

    /**
     * @param user user param
     * @return user
     */
    @ApiOperation("Add")
    @PostMapping("add")
    public ResponseResult<User> add(User user) {
        redisService.set(String.valueOf(user.getId()), user);
        return ResponseResult.success(redisService.get(String.valueOf(user.getId())));
    }

    /**
     * @return user list
     */
    @ApiOperation("Find")
    @GetMapping("find/{userId}")
    public ResponseResult<User> edit(@PathVariable("userId") String userId) {
        return ResponseResult.success(redisService.get(userId));
    }

}
