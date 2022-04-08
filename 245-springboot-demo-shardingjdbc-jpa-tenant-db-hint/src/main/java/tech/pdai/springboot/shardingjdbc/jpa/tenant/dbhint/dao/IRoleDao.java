package tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.entity.Role;

/**
 * @author pdai
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Long> {

}
