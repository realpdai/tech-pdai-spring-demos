package tech.pdai.springboot.mysql57.mybatis.anno.dao;

import org.apache.ibatis.annotations.*;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.User;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.query.UserQueryBean;

import java.util.List;

/**
 * @author pdai
 */
@Mapper
public interface IUserDao {

//    <resultMap type="tech.pdai.springboot.mysql57.mybatis.xml.entity.User" id="UserResult">
//		<id     property="id"       	column="id"      		/>
//		<result property="userName"     column="user_name"    	/>
//		<result property="password"     column="password"    	/>
//		<result property="email"        column="email"        	/>
//		<result property="phoneNumber"  column="phone_number"  	/>
//		<result property="description"  column="description"  	/>
//		<result property="createTime"   column="create_time"  	/>
//		<result property="updateTime"   column="update_time"  	/>
//		<collection property="roles" ofType="tech.pdai.springboot.mysql57.mybatis.xml.entity.Role">
//			<result property="id" column="id"  />
//			<result property="name" column="name"  />
//			<result property="roleKey" column="role_key"  />
//			<result property="description" column="description"  />
//			<result property="createTime"   column="create_time"  	/>
//			<result property="updateTime"   column="update_time"  	/>
//		</collection>
//	</resultMap>

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
                    @Result(property = "updateTime", column = "update_time")
            }
    )
    @Select("select u.id, u.password, u.user_name, u.email, u.phone_number, u.description, u.create_time, u.update_time from tb_user u where id = #{id}")
    User findById1(@Param("id") Long id);

    @ResultMap("UserResult")
    @Select("select u.id, u.password, u.user_name, u.email, u.phone_number, u.description, u.create_time, u.update_time from tb_user u")
    User findAll1();


    List<User> findList(UserQueryBean userQueryBean);



    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);
}
