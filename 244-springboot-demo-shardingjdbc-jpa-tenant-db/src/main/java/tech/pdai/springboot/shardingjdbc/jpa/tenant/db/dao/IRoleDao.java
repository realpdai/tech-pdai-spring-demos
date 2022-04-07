package tech.pdai.springboot.shardingjdbc.jpa.tenant.db.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.db.entity.Role;

/**
 * @author pdai
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Long> {

}
