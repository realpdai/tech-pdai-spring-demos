package tech.pdai.springboot2unit5.service.impl;

import org.springframework.stereotype.Service;
import tech.pdai.springboot2unit5.dao.UserRepository;
import tech.pdai.springboot2unit5.entity.User;
import tech.pdai.springboot2unit5.service.IUserService;

import java.util.List;

/**
 * User service impl.
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * user dao.
     */
    private final UserRepository userRepository;

    /**
     * init.
     *
     * @param userRepository2 user dao
     */
    public UserServiceImpl(final UserRepository userRepository2) {
        this.userRepository = userRepository2;
    }

    /**
     * find all user.
     *
     * @return list
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
