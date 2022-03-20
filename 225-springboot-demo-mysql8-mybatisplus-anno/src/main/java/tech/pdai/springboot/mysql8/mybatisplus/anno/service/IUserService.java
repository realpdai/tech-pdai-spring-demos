package tech.pdai.springboot.mysql8.mybatisplus.anno.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.query.UserQueryBean;

import java.util.List;

/**
 * @author pdai
 */
public interface IUserService extends IService<User> {

    List<User> findList(UserQueryBean userQueryBean);

}
