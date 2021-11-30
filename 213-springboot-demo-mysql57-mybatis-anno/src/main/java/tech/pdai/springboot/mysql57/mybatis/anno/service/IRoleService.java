package tech.pdai.springboot.mysql57.mybatis.anno.service;


import java.util.List;

import tech.pdai.springboot.mysql57.mybatis.anno.entity.Role;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.query.RoleQueryBean;

public interface IRoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
