package com.van.security.service;

import com.van.security.domain.SysPermission;
import com.van.security.domain.SysUser;
import com.van.security.mapper.SysUserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static Logger log = LogManager.getLogger(MyUserDetailsService.class);

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("在MyUserDetailsService 中通过用户名查询权限信息，用户名为: "+ userName +"");
        SysUser user = sysUserMapper.findByUserName(userName);
        if(user != null){
            List<SysPermission> permissions = sysUserMapper.findPermissionByUserName(userName);
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (permissions != null){
                for(SysPermission permission : permissions){
                    GrantedAuthority authority = new SimpleGrantedAuthority(permission.getName());
                    //将用户的权限名称加入List<SysPermission> 中
                    authorities.add(authority);
                    log.info("在MyUserDetailsService中将用户拥有的权限名称加入GrantedAuthority中。" + permission.toString());
                }
            }
            return new User(user.getUserName(), user.getPassword(), authorities);
        }
        else {
            throw new UsernameNotFoundException("为查询到用户名为: "+ userName +" 的任何信息！");
        }
    }
}
