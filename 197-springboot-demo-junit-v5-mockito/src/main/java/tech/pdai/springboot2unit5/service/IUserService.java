package tech.pdai.springboot2unit5.service;

import tech.pdai.springboot2unit5.entity.User;

import java.util.List;

/**
 * user service
 */
public interface IUserService {

    /**
     * find all user.
     *
     * @return list
     */
    List<User> findAll();
}
