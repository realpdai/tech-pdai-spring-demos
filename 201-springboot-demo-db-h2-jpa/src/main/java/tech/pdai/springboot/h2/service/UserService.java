package tech.pdai.springboot.h2.service;

import java.util.List;

import tech.pdai.springboot.h2.entity.User;

public interface UserService {

    void addUser(User user);

    List<User> list();

}
