package tech.pdai.springboot.shardingjdbc.jpa.tenant.db.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * @author pdai
 */
public interface IBaseService<T, I extends Serializable> {

    /**
     * @param id id
     * @return T
     */
    T find(I id);

    /**
     * @return List
     */
    List<T> findAll();

    /**
     * @param ids ids
     * @return List
     */
    List<T> findList(I[] ids);

    /**
     * @param ids ids
     * @return List
     */
    List<T> findList(Iterable<I> ids);

    /**
     * @param pageable pageable
     * @return Page
     */
    Page<T> findAll(Pageable pageable);

    /**
     * @param spec     spec
     * @param pageable pageable
     * @return Page
     */
    Page<T> findAll(Specification<T> spec, Pageable pageable);

    /**
     * @param spec spec
     * @return T
     */
    T findOne(Specification<T> spec);

    /**
     * count.
     *
     * @return long
     */
    long count();

    /**
     * count.
     *
     * @param spec spec
     * @return long
     */
    long count(Specification<T> spec);

    /**
     * exists.
     *
     * @param id id
     * @return boolean
     */
    boolean exists(I id);

    /**
     * save.
     *
     * @param entity entity
     */
    void save(T entity);

    /**
     * save.
     *
     * @param entities entities
     */
    void save(List<T> entities);

    /**
     * update.
     *
     * @param entity entity
     * @return T
     */
    T update(T entity);

    /**
     * delete.
     *
     * @param id id
     */
    void delete(I id);

    /**
     * delete by ids.
     *
     * @param ids ids
     */
    void deleteByIds(List<I> ids);

    /**
     * delete.
     *
     * @param entities entities
     */
    void delete(T[] entities);

    /**
     * delete.
     *
     * @param entities entities
     */
    void delete(Iterable<T> entities);

    /**
     * delete.
     *
     * @param entity entity
     */
    void delete(T entity);

    /**
     * delete all.
     */
    void deleteAll();

    /**
     * find list.
     *
     * @param spec spec
     * @return list
     */
    List<T> findList(Specification<T> spec);

    /**
     * find list.
     *
     * @param spec spec
     * @param sort sort
     * @return List
     */
    List<T> findList(Specification<T> spec, Sort sort);


    /**
     * flush.
     */
    void flush();

}
