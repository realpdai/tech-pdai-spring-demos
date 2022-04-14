package tech.pdai.springboot.postgre.mybatisplus.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.pdai.springboot.postgre.mybatisplus.entity.User;
import tech.pdai.springboot.postgre.mybatisplus.entity.query.UserQueryBean;

/**
 * @author pdai
 */
public interface IUserService extends IService<User> {

    List<User> findList(UserQueryBean userQueryBean);

}
