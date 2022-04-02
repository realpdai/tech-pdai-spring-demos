package tech.pdai.springboot.mysql8.mybatisplus.tenant.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.dao.IUserDao;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.query.UserQueryBean;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.service.IUserService;

@Service
public class UserDoServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {

    @Override
    public List<User> findList(UserQueryBean userQueryBean) {
        return baseMapper.findList(userQueryBean);
    }
}
