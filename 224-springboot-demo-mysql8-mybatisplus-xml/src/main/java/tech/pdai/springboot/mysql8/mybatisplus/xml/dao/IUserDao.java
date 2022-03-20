package tech.pdai.springboot.mysql8.mybatisplus.xml.dao;

import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.UserQueryBean;

import java.util.List;

/**
 * @author pdai
 */
public interface IUserDao {

    List<User> findList(UserQueryBean userQueryBean);

    User findById(Long id);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);
}
