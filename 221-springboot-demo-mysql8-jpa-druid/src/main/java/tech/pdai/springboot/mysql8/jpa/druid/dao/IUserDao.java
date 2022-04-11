package tech.pdai.springboot.mysql8.jpa.druid.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.mysql8.jpa.druid.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
