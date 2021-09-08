package tech.pdai.springboot.mysql57.druid.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.mysql57.druid.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
