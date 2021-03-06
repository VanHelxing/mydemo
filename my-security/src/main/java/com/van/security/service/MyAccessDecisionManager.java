package com.van.security.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    private static Logger log = LogManager.getLogger(MyAccessDecisionManager.class);

    //decide 方法是判定是否拥有权限的决策方法，
    //authentication 是MyUserDetailsService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在资源表中，如果在资源表中，则返回给 decide 方法，用来判定用户是否有此权限
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes == null ||configAttributes.size() == 0){
            //说明该资源没有分配给角色, 这里不允许访问
            throw new AccessDeniedException("暂无权限访问该资源！");
        }

        ConfigAttribute c;
        String needRole;

        //遍历当前访问的资源需要的角色
        for(Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext();){
            c = iter.next();
            needRole = c.getAttribute();

            //遍历当前用户所拥有的角色
            for(GrantedAuthority authority : authentication.getAuthorities()){
                //管理员则直接放行
                if("ROLE_ADMIN".equals(authority.getAuthority())){
                    return;
                }
                //匹配到则放行
                if(needRole.trim().equals(authority.getAuthority())){
                    return;
                }
            }
        }

        throw  new AccessDeniedException("您无权限访问此资源!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
