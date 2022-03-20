package tech.pdai.springboot.mysql8.mybatisplus.xml.service;

import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.UserQueryBean;

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

}
