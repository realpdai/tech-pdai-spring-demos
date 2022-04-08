package tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
