package tech.pdai.springboot.mysql57.jpa.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.mysql57.jpa.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
