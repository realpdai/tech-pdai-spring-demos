package tech.pdai.springboot.postgre.mybatisplus.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.postgre.mybatisplus.dao.IUserDao;
import tech.pdai.springboot.postgre.mybatisplus.entity.User;
import tech.pdai.springboot.postgre.mybatisplus.entity.query.UserQueryBean;
import tech.pdai.springboot.postgre.mybatisplus.service.IUserService;

@Service
public class UserDoServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {

    @Override
    public List<User> findList(UserQueryBean userQueryBean) {
        return baseMapper.findList(userQueryBean);
    }
}
