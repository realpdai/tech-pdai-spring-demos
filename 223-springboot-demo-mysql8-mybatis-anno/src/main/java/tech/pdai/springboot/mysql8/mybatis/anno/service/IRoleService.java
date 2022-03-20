package tech.pdai.springboot.mysql8.mybatis.anno.service;


import tech.pdai.springboot.mysql8.mybatis.anno.entity.Role;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.query.RoleQueryBean;

import java.util.List;

public interface IRoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
