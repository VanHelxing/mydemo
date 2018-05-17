package com.van.common.service;

import com.van.common.dao.BaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * BaseService实现类
 * @param <T> the type parameter
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@NoRepositoryBean
public class BaseServiceImpl <T> implements BaseService<T> {

    @Resource
    private BaseDao<T> baseDao;


    /**
     * Save s.
     *
     * @param s the s
     * @return the s
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public T save(T s) {
        return baseDao.save(s);
    }

    /**
     * Delete.
     *
     * @param s the s
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public void delete(T s) {
        baseDao.delete(s);
    }

    /**
     * Find by id t.
     *
     * @param id the id
     * @return the t
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public T findById(String id) {
        return baseDao.getOne(id);
    }

    /**
     * Find all list.
     *
     * @return the list
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseDao.findAll(pageable);
    }

    /**
     * Find all list.
     *
     * @param spec the spec
     * @return the list
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public List<T> findAll(Specification<T> spec) {
        return baseDao.findAll(spec);
    }

    /**
     * Find all page.
     *
     * @param spec     the spec
     * @param pageable the pageable
     * @return the page
     * @author : yangjunqing / 2018-05-16
     */
    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return baseDao.findAll(spec, pageable);
    }
}
