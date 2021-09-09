package tech.pdai.springboot.mysql57.mybatis.xml.service;

import java.util.List;

import tech.pdai.springboot.mysql57.mybatis.xml.entity.Role;
import tech.pdai.springboot.mysql57.mybatis.xml.entity.query.RoleQueryBean;

public interface IRoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
