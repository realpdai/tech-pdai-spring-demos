package tech.pdai.springboot.mysql57.mybatis.anno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.Role;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.query.RoleQueryBean;

/**
 * @author pdai
 */
@Mapper
public interface IRoleDao {

    @Results(
            id = "RoleResult",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "roleKey", column = "role_key"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "createTime", column = "create_time"),
                    @Result(property = "updateTime", column = "update_time")
            }
    )
    @Select({"select r.id, r.name, r.role_key, r.description, r.create_time, r.update_time" +
            " from tb_role r where r.id != 0",})
    List<Role> findList(RoleQueryBean roleQueryBean);

    @ResultMap("RoleResult")
    @Select("select r.id, r.name, r.role_key, r.description, r.create_time, r.update_time from tb_role r, tb_user_role ur where r.id = ur.user_id and ur.user_id = #{userId}")
    List<Role> findRoleByUserId(Long userId);
}
