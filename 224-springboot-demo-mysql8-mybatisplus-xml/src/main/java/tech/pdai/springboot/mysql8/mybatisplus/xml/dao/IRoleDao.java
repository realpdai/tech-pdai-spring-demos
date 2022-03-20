package tech.pdai.springboot.mysql8.mybatisplus.xml.dao;

import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.xml.entity.query.RoleQueryBean;

import java.util.List;

/**
 * @author pdai
 */
public interface IRoleDao {
    List<Role> findList(RoleQueryBean roleQueryBean);
}
