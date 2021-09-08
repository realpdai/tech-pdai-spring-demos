package tech.pdai.springboot.postgre.jpa.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.postgre.jpa.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
