package tech.pdai.springboot.postgre.jpa.druid.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.postgre.jpa.druid.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
