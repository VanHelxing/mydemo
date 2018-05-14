package com.van.security.service;

import com.van.security.domain.SysPermission;
import com.van.security.mapper.SysPermissionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Map<String, Collection<ConfigAttribute>> map = null;

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 加载权限表中所有的权限,
     */
    public void loadResourceDefine(){
        log.info("在MyInvocationSecurityMetadataSourceServiceImpl加载了数据库中所有的权限!");
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SysPermission> permissions = sysPermissionMapper.findByParams(new HashMap<String, Object>());
        for (SysPermission permission : permissions){
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getName());
            //此处只添加了权限需要的角色
            array.add(cfg);
            //用权限的url作为key, ConfigAttribute集合作为value
            map.put(permission.getUrl(), array);
        }
    }


    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        log.info("在MyInvocationSecurityMetadataSourceService 的getAttributes方法里寻找用户访问路径需要的权限角色!");
        //加载权限
        if(map == null){
            loadResourceDefine();
        }
        //object中包含用户的请求request信息
        HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();){
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)){
                Collection<ConfigAttribute> attributes = map.get(resUrl);
                for (ConfigAttribute config : attributes){
                    log.info("在MyInvocationSecurityMetadataSourceService中, 查找到访问该路径需要角色【"+ config.getAttribute() +"】");
                }

                return map.get(resUrl);
            }
        }
        return null;
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
