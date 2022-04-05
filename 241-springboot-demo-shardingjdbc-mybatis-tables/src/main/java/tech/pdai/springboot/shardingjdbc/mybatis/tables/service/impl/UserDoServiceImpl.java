package tech.pdai.springboot.shardingjdbc.mybatis.tables.service.impl;

import tech.pdai.springboot.shardingjdbc.mybatis.tables.dao.IUserDao;
import tech.pdai.springboot.shardingjdbc.mybatis.tables.entity.User;
import tech.pdai.springboot.shardingjdbc.mybatis.tables.entity.query.UserQueryBean;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.shardingjdbc.mybatis.tables.service.IUserService;

import java.util.List;

@Service
public class UserDoServiceImpl implements IUserService {

    /**
     * userDao.
     */
    private final IUserDao userDao;

    /**
     * init.
     *
     * @param userDao2 user dao
     */
    public UserDoServiceImpl(final IUserDao userDao2) {
        this.userDao = userDao2;
    }

    @Override
    public List<User> findList(UserQueryBean userQueryBean) {
        return userDao.findList(userQueryBean);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public int deleteByIds(Long[] ids) {
        return userDao.deleteByIds(ids);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int updatePassword(User user) {
        return userDao.updatePassword(user);
    }

    @Override
    public User findById2(Long userId) {
        return userDao.findById2(userId);
    }
}
