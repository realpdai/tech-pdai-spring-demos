package tech.pdai.springboot.mysql8.mybatisplus.anno.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.mysql8.mybatisplus.anno.dao.IUserDao;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.query.UserQueryBean;
import tech.pdai.springboot.mysql8.mybatisplus.anno.service.IUserService;

import java.util.List;

@Service
public class UserDoServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {

    @Override
    public List<User> findList(UserQueryBean userQueryBean) {
        return baseMapper.findList(userQueryBean);
    }
}
