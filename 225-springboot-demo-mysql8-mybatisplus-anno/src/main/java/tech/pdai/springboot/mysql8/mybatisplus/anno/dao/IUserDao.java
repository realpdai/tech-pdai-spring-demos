package tech.pdai.springboot.mysql8.mybatisplus.anno.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.query.UserQueryBean;

import java.util.List;

/**
 * @author pdai
 */
public interface IUserDao extends BaseMapper<User> {

    List<User> findList(UserQueryBean userQueryBean);
}
