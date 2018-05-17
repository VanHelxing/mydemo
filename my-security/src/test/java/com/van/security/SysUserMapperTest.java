package com.van.security;

import com.van.security.domain.SysUser;
import com.van.security.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void findByUserName(){
        SysUser user = sysUserMapper.findByUserName("admin");
        System.out.println(user.toString());
        System.out.println(user.getRoles().get(0).getName());
    }
}
