package com.van.common.dao;

import com.van.common.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {


    /**
     * 通过客户编号查询信息
     * @param cusId
     * @return
     */
    public Customer findByCusId(String cusId);


    /**
     * 通过客户电话查询信息
     * @param cusTel
     * @return
     */
    public Customer findByCusTel(String cusTel);

}
