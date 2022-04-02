package tech.pdai.springboot.mysql8.mybatisplus.tenant.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.query.UserQueryBean;

/**
 * @author pdai
 */
public interface IUserDao extends BaseMapper<User> {

    List<User> findList(UserQueryBean userQueryBean);
}
