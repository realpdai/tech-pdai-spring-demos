package tech.pdai.springboot.mysql8.mybatis.anno.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tech.pdai.springboot.mysql8.mybatis.anno.dao.provider.UserDaoProvider;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.User;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.query.UserQueryBean;

import java.util.List;

/**
 * @author pdai
 */
@Mapper
public interface IUserDao {

    String SELECT_USER_SQL = "select u.id, u.password, u.user_name, u.email, u.phone_number, u.description, u.create_time, u.update_time from tb_user u";

    @Results(
            id = "UserResult",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "userName", column = "user_name"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "phoneNumber", column = "phone_number"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "createTime", column = "create_time"),
                    @Result(property = "updateTime", column = "update_time"),
                    @Result(property = "roles", column = "id", many = @Many(select = "tech.pdai.springboot.mysql8.mybatis.anno.dao.IRoleDao.findRoleByUserId", fetchType = FetchType.EAGER))
            }
    )
    @Select({SELECT_USER_SQL, " where id = #{id}"})
    User findById(@Param("id") Long id);

    @ResultMap("UserResult")
    @Select(SELECT_USER_SQL)
    User findAll();

    @ResultMap("UserResult")
    @Select({"<script> ", SELECT_USER_SQL, " where u.id != 0\n" +
            "\t\t<if test=\"userName != null and userName != ''\">\n" +
            "AND u.user_name like concat('%', #{user_name}, '%')\n" +
            "\t\t</if>\n" +
            "\t\t<if test=\"description != null and description != ''\">\n" +
            "AND u.description like concat('%', #{description}, '%')\n" +
            "\t\t</if>\n" +
            "\t\t<if test=\"phoneNumber != null and phoneNumber != ''\">\n" +
            "AND u.phone_number like concat('%', #{phoneNumber}, '%')\n" +
            "\t\t</if>\n" +
            "\t\t<if test=\"email != null and email != ''\">\n" +
            "AND u.email like concat('%', #{email}, '%')\n" +
            "\t\t</if>", " </script>"})
    List<User> findList(UserQueryBean userQueryBean);

    @Delete("delete from tb_user where id = #{id}")
    int deleteById(Long id);

    @Delete({"<script> ", "delete from tb_user where id in\n" +
            "<foreach collection=\"array\" item=\"id\" open=\"(\" separator=\",\" close=\")\">\n" +
            "#{id}\n" +
            "</foreach>", " </script>"})
    int deleteByIds(Long[] ids);

    @Update({"<script> ", "update tb_user\n" +
            " <set>\n" +
            " <if test=\"userName != null and userName != ''\">user_name = #{userName},</if>\n" +
            " <if test=\"email != null and email != ''\">email = #{email},</if>\n" +
            " <if test=\"phoneNumber != null and phoneNumber != ''\">phone_number = #{phoneNumber},</if>\n" +
            " <if test=\"description != null and description != ''\">description = #{description},</if>\n" +
            " update_time = sysdate()\n" +
            " </set>\n" +
            " where id = #{id}", " </script>"})
    int update(User user);

    @Insert({"<script> ", "insert into tb_user(\n" +
            " <if test=\"userName != null and userName != ''\">user_name,</if>\n" +
            " <if test=\"password != null and password != ''\">password,</if>\n" +
            " <if test=\"email != null and email != ''\">email,</if>\n" +
            " <if test=\"phoneNumber != null and phoneNumber != ''\">phone_number,</if>\n" +
            " <if test=\"description != null and description != ''\">description,</if>\n" +
            " create_time,\n" +
            " update_time\n" +
            " )values(\n" +
            " <if test=\"userName != null and userName != ''\">#{userName},</if>\n" +
            " <if test=\"password != null and password != ''\">#{password},</if>\n" +
            " <if test=\"email != null and email != ''\">#{email},</if>\n" +
            " <if test=\"phoneNumber != null and phoneNumber != ''\">#{phoneNumber},</if>\n" +
            " <if test=\"description != null and description != ''\">#{description},</if>\n" +
            " sysdate(),\n" +
            " sysdate()\n" +
            " )", " </script>"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);

    @Update({"update tb_user set password = #{password}, update_time = sysdate()", " where id = #{id}"})
    int updatePassword(User user);

    @ResultMap("UserResult")
    @SelectProvider(type = UserDaoProvider.class, method = "findById")
    User findById2(Long id);


}
