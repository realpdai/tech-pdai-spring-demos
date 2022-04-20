package tech.pdai.springboot.mysql8.jpa.dockercompose.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.mysql8.jpa.dockercompose.entity.Role;

/**
 * @author pdai
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Long> {

}
