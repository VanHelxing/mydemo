package com.van.security.mapper;

import com.van.security.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserMapper {

    public SysUser findByUserName(@Param("userName")String userName);

    public List<SysUser> findByParams(Map<String, Object> params);
}
