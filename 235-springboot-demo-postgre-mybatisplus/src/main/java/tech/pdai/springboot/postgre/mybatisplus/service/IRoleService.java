package tech.pdai.springboot.postgre.mybatisplus.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.pdai.springboot.postgre.mybatisplus.entity.Role;
import tech.pdai.springboot.postgre.mybatisplus.entity.query.RoleQueryBean;

public interface IRoleService extends IService<Role> {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
