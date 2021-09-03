package tech.pdai.springboot.swagger.service;

import java.util.List;

import tech.pdai.springboot.swagger.entity.User;

/**
 * user service.
 *
 * @author pdai
 */
public interface UserService {

    /**
     * @param user user
     */
    void addUser(User user);

    /**
     * @return user list
     */
    List<User> list();

}
