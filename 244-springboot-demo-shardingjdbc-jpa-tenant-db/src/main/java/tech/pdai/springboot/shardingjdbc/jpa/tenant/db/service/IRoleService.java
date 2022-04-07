package tech.pdai.springboot.shardingjdbc.jpa.tenant.db.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.db.entity.Role;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.db.entity.query.RoleQueryBean;

public interface IRoleService extends IBaseService<Role, Long> {

    /**
     * find page by query.
     *
     * @param roleQueryBean query
     * @param pageRequest   pageRequest
     * @return page
     */
    Page<Role> findPage(RoleQueryBean roleQueryBean, PageRequest pageRequest);

}
