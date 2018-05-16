package com.van.common;

import com.van.common.dao.CustomerDao;
import com.van.common.domain.Customer;
import com.van.common.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerTest {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private CustomerService customerService;


    @Test
    public void select(){

        Customer customer = new Customer();
        Date currentDate = new Date();

        customer.setId("e74af5fc-3925-4054-97ae-c447d20aa7b4");
        customer.setCusId("CU000012018051500002");
        customer.setCusName("龙骑士");
        customer.setCusSexy("1");
        customer.setCusTel("18029056654");
        customer.setCreateDate(currentDate);
//        customer.setLastModifyDate(currentDate);
        customer.setStatus("1");

        customerService.save(customer);

        System.out.println("保存成功！");



//        Customer customer = customerDao.getOne("CU000012018051500001");
//        if (customer != null){
//            System.out.println(customer.toString());
//        }else {
//            System.out.println("没有找到符合数据！");
//        }

    }

}
