package tech.pdai.springboot.postgre.jpa.druid.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.postgre.jpa.druid.entity.Role;

/**
 * @author pdai
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Long> {

}
