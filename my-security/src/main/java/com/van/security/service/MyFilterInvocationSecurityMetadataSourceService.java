package com.van.security.service;

import com.van.security.domain.SysPermission;
import com.van.security.domain.SysRole;
import com.van.security.mapper.SysPermissionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class MyFilterInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    private static Logger log = LogManager.getLogger(MyFilterInvocationSecurityMetadataSourceService.class);

    private Map<String, Collection<ConfigAttribute>> permissionMap = null;

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 加载权限表中所有的权限,
     */
    public void loadResourceDefine(){
        log.debug("加载了数据库中所有权限角色!");
        permissionMap = new HashMap<>();
        Collection<ConfigAttribute> attributes;
        ConfigAttribute attribute;
        List<SysRole> roles;

        //查找资源表中的所有有效的数据
        //这里有待改进, 比如父ID可以拥有子的权限...
        List<SysPermission> permissions = sysPermissionMapper.findAll();

        //遍历每个资源
        for (SysPermission permission : permissions){
            attributes = new ArrayList<>();
            roles = permission.getRoles();
            //遍历每个角色
            for (SysRole role : roles){
                attribute = new SecurityConfig(role.getName());
                //此处只添加了该资源需要的角色
                attributes.add(attribute);
            }
            //用权限的url作为key, ConfigAttribute集合作为value
            permissionMap.put(permission.getUrl(), attributes);
        }
    }


    //此方法是为了判定用户请求的url 是否在资源表中，如果在资源表中，则返回给 decide 方法，用来判定用户是否有此权限。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        log.info("查询访问路的资源需要的角色!");
        //加载权限info
        if(permissionMap == null){
            synchronized (MyFilterInvocationSecurityMetadataSourceService.class) {
                if(permissionMap == null) {
                    loadResourceDefine();
                }
            }
        }
        //object中包含用户的请求request信息
        HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = permissionMap.keySet().iterator(); iter.hasNext();){
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)){
                Collection<ConfigAttribute> attributes = permissionMap.get(resUrl);
                for (ConfigAttribute config : attributes){
                    log.info("查找到访问该路径需要角色【"+ config.getAttribute() +"】");
                }

                return permissionMap.get(resUrl);
            }
        }

        return null; //返回等于放行
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
