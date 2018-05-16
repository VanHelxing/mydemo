package com.van.common.service;

import com.van.common.dao.CustomerDao;
import com.van.common.domain.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService  {

    @Resource
    private CustomerDao customerDao;

}
