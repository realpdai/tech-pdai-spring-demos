package tech.pdai.springboot.mysql8.mybatisplus.xml.service;

import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.RoleQueryBean;

import java.util.List;

public interface IRoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
