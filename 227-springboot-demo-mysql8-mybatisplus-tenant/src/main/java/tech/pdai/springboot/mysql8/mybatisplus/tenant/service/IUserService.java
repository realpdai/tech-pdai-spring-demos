package tech.pdai.springboot.mysql8.mybatisplus.tenant.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.User;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.query.UserQueryBean;

/**
 * @author pdai
 */
public interface IUserService extends IService<User> {

    List<User> findList(UserQueryBean userQueryBean);

}
