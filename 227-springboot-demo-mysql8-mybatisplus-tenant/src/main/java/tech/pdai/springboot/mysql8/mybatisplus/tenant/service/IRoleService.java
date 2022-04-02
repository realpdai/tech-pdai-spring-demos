package tech.pdai.springboot.mysql8.mybatisplus.tenant.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.query.RoleQueryBean;

public interface IRoleService extends IService<Role> {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
