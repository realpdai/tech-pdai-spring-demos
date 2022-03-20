package tech.pdai.springboot.mysql8.mybatisplus.anno.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.query.RoleQueryBean;

import java.util.List;

public interface IRoleService extends IService<Role> {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
