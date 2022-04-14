package tech.pdai.springboot.postgre.mybatisplus.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tech.pdai.springboot.postgre.mybatisplus.entity.User;
import tech.pdai.springboot.postgre.mybatisplus.entity.query.UserQueryBean;

/**
 * @author pdai
 */
public interface IUserDao extends BaseMapper<User> {

    List<User> findList(UserQueryBean userQueryBean);
}
