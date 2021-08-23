package tech.pdai.springframework.service;

import tech.pdai.springframework.entity.User;

import java.util.List;

/**
 * @author pdai
 */
public interface IUserService {

    /**
     * find user list.
     *
     * @return user list
     */
    List<User> findUserList();

    /**
     * add user
     */
    void addUser();
}
