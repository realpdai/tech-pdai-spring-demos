package tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.entity.BaseEntity;

/**
 * @author pdai
 */
@NoRepositoryBean
public interface IBaseDao<T extends BaseEntity, I extends Serializable>
        extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
