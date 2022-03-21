package tech.pdai.springboot.mysql57.mybatisplus.xml.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.pdai.springboot.mysql57.mybatisplus.xml.entity.Role;
import tech.pdai.springboot.mysql57.mybatisplus.xml.entity.query.RoleQueryBean;

import java.util.List;

/**
 * @author pdai
 */
@Mapper
public interface IRoleDao {
    List<Role> findList(RoleQueryBean roleQueryBean);
}
