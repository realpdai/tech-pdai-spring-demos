package tech.pdai.springboot.mysql8.jpa.dockercompose.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.mysql8.jpa.dockercompose.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
