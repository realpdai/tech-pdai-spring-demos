package tech.pdai.springboot.swagger.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.swagger.entity.User;

/**
 * @author pdai
 */
@Repository
public class UserRepository {

    private List<User> userDemoList = new ArrayList<>();

    public void save(User user) {
        userDemoList.add(user);
    }

    public List<User> findAll() {
        return userDemoList;
    }
}
