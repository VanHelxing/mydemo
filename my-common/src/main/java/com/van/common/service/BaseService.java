package com.van.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


/**
 * 通用方法Service接口
 *
 * @param <T> the type parameter
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface BaseService<T> {


    /**
     * Save s.
     *
     * @param s the s
     * @return the s
     * @author : yangjunqing / 2018-05-16
     */
    public T save(T s);


    /**
     * Delete.
     *
     * @param s the s
     * @author : yangjunqing / 2018-05-16
     */
    public void delete(T s);

    /**
     * Find by id t.
     *
     * @param id the id
     * @return the t
     * @author : yangjunqing / 2018-05-16
     */
    public T findById(String id);

    /**
     * Find all list.
     *
     * @return the list
     * @author : yangjunqing / 2018-05-16
     */
    public List<T> findAll();

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     * @author : yangjunqing / 2018-05-16
     */
    public Page<T> findAll(Pageable pageable);

    /**
     * Find all list.
     *
     * @param spec the spec
     * @return the list
     * @author : yangjunqing / 2018-05-16
     */
    public List<T> findAll(Specification<T> spec);

    /**
     * Find all page.
     *
     * @param spec     the spec
     * @param pageable the pageable
     * @return the page
     * @author : yangjunqing / 2018-05-16
     */
    public Page<T> findAll(Specification<T> spec, Pageable pageable);

}
