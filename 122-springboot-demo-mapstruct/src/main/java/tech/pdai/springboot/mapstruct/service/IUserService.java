package tech.pdai.springboot.mapstruct.service;

import java.util.List;

import tech.pdai.springboot.mapstruct.entity.param.UserQueryParam;
import tech.pdai.springboot.mapstruct.entity.vo.UserVo;
import tech.pdai.springboot.mapstruct.entity.vo.UserWithAddressVo;

/**
 * @author pdai
 */
public interface IUserService {
    List<UserVo> userList(UserQueryParam userParam);

    UserWithAddressVo bindAddressTest(UserQueryParam userParam);
}
