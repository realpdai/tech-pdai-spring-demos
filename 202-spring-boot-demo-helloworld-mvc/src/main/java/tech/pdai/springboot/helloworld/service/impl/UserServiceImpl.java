package tech.pdai.springboot.helloworld.service.impl;

import com.pdai.swagger.dao.UserResponsitory;
import com.pdai.swagger.entity.User;
import com.pdai.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserResponsitory userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

}
