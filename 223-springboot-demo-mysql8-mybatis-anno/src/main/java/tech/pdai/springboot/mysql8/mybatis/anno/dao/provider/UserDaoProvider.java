package tech.pdai.springboot.mysql8.mybatis.anno.dao.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author pdai
 */
public class UserDaoProvider {

    public String findById(final Long id) {
        SQL sql = new SQL();
        sql.SELECT("u.id, u.password, u.user_name, u.email, u.phone_number, u.description, u.create_time, u.update_time");
        sql.FROM("tb_user u");
        sql.WHERE("id = " + id);
        return sql.toString();
    }
}
