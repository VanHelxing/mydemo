package com.van.security.service;

import com.van.security.domain.SysPermission;
import com.van.security.domain.SysUser;
import com.van.security.mapper.SysUserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static Logger log = LogManager.getLogger(MyUserDetailsService.class);

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findByUserName(userName);
        if(user != null){
            
        }
    }
}
