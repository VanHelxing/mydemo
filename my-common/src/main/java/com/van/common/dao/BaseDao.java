package com.van.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@NoRepositoryBean  //一般用作父类的repository，有这个注解，spring不会去实例化该repository
public interface BaseDao <T> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {

}
