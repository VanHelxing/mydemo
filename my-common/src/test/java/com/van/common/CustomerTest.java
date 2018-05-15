package com.van.common;

import com.van.common.dao.CustomerDao;
import com.van.common.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerTest {

    @Resource
    private CustomerDao customerDao;


    @Test
    public void select(){

        Customer customer = customerDao.findByCusTel("18029056653");
        if (customer != null){
            System.out.println(customer.toString());
        }else {
            System.out.println("没有找到符合数据！");
        }

    }

}
