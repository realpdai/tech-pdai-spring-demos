package tech.pdai.springboot.shardingjdbc.jpa.tenant.db.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.db.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
