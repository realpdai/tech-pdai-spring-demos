package tech.pdai.springboot.mapstruct.mapper;


import java.util.List;

import com.alibaba.fastjson.JSON;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.pdai.springboot.mapstruct.entity.Address;
import tech.pdai.springboot.mapstruct.entity.User;
import tech.pdai.springboot.mapstruct.entity.param.UserQueryParam;
import tech.pdai.springboot.mapstruct.entity.vo.UserVo;
import tech.pdai.springboot.mapstruct.entity.vo.UserWithAddressVo;

/**
 * @author pdai
 */
@Mapper(componentModel="spring")
public interface UserConverter {

    @Mapping(target = "gender", source = "user.sex")
    @Mapping(target = "configs", source = "user.config")
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVo do2vo(User user);

    @Mapping(target = "sex", source = "gender")
    @Mapping(target = "config", source = "configs")
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    User vo2Do(UserVo userVo);

    UserQueryParam vo2QueryParam(User var1);

    List<UserVo> do2voList(List<User> userList);

    @Mapping(target = "description", source = "user.description")
    @Mapping(target = "houseNumber", source = "address.houseNo")
    UserWithAddressVo userAndAddress2Vo(User user, Address address);

    default List<UserVo.UserConfig> mapConfigs(String config) {
        return JSON.parseArray(config, UserVo.UserConfig.class);
    }

    default String mapConfig(List<UserVo.UserConfig> configs) {
        return JSON.toJSONString(configs);
    }
}