package tech.pdai.springboot.mapstruct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.pdai.springboot.mapstruct.dao.IUserDao;
import tech.pdai.springboot.mapstruct.entity.Address;
import tech.pdai.springboot.mapstruct.entity.User;
import tech.pdai.springboot.mapstruct.entity.param.UserQueryParam;
import tech.pdai.springboot.mapstruct.entity.vo.UserVo;
import tech.pdai.springboot.mapstruct.entity.vo.UserWithAddressVo;
import tech.pdai.springboot.mapstruct.mapper.UserConverter;

/**
 * @author pdai
 */
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserVo> userList(UserQueryParam userParam) {
        List<User> userList = userDao.list(userParam);
        return userConverter.do2voList(userList);
    }

    @Override
    public UserWithAddressVo bindAddressTest(UserQueryParam userParam) {
        User user = userDao.list(userParam).get(0);
        return userConverter.userAndAddress2Vo(user, Address.builder()
                .description("address desc")
                .houseNo(1212)
                .street("address street")
                .zipCode(111111)
                .build());
    }

}
