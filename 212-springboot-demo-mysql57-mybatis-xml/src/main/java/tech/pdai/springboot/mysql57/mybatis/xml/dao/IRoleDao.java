package tech.pdai.springboot.mysql57.mybatis.xml.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tech.pdai.springboot.mysql57.mybatis.xml.entity.Role;
import tech.pdai.springboot.mysql57.mybatis.xml.entity.query.RoleQueryBean;

/**
 * @author pdai
 */
@Mapper
public interface IRoleDao {
    List<Role> findList(RoleQueryBean roleQueryBean);
}
