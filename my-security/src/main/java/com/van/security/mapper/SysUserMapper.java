package com.van.security.mapper;

import com.van.security.domain.SysPermission;
import com.van.security.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserMapper {

    /**
     * 用户名查询用户信息
     * @param userName
     * @return
     */
    public SysUser findByUserName(@Param("userName")String userName);

    /**
     * 查询用户所拥有的权限
     * @param userName
     * @return
     */
    public List<SysPermission> findPermissionByUserName(@Param("userName")String userName);

    /**
     * 条件查询用户信息
     * @param params
     * @return
     */
    public List<SysUser> findByParams(Map<String, Object> params);
}
