package tech.pdai.springboot.mysql8.jpa.hikari.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.mysql8.jpa.hikari.entity.User;

/**
 * @author pdai
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}
