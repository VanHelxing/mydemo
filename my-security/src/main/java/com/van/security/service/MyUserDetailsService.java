package com.van.security.service;

import com.van.security.domain.SysRole;
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
        log.debug("通过提交的用户名查询角色信息，用户名为: "+ userName +"");
        SysUser user = sysUserMapper.findByUserName(userName);
        if(user != null){
            List<SysRole> roles = user.getRoles();
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (roles != null){
                for(SysRole role : roles){
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                    //将用户的角色名称加入authorities中
                    authorities.add(authority);
                    log.debug("将用户的角色加入GrantedAuthority中。" + role.getName());
                }
            }
            return new User(user.getUserName(), user.getPassword(), authorities);
        }
        else {
            throw new UsernameNotFoundException("未查询到用户名为: "+ userName +" 的任何信息！");
        }
    }
}
