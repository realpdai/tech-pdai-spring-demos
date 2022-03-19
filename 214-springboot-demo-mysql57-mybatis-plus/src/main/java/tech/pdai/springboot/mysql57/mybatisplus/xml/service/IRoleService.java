package tech.pdai.springboot.mysql57.mybatisplus.xml.service;

import tech.pdai.springboot.mysql57.mybatisplus.xml.entity.Role;
import tech.pdai.springboot.mysql57.mybatisplus.xml.entity.query.RoleQueryBean;

import java.util.List;

public interface IRoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
