package tech.pdai.springboot.helloworld.service;

import com.pdai.swagger.entity.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> list();

}
