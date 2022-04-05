package tech.pdai.springboot.shardingjdbc.mybatis.tables.service;

import tech.pdai.springboot.shardingjdbc.mybatis.tables.entity.User;
import tech.pdai.springboot.shardingjdbc.mybatis.tables.entity.query.UserQueryBean;

import java.util.List;

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
