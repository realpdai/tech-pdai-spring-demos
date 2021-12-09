package tech.pdai.springboot.mysql57.mybatis.anno.service;


import java.util.List;

import tech.pdai.springboot.mysql57.mybatis.anno.entity.User;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.query.UserQueryBean;

/**
 * @author pdai
 */
public interface IUserService {

    List<User> findList(UserQueryBean userQueryBean);

    User findById(Long id);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);

    User findById2(Long userId);
}
