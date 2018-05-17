package com.van.security.mapper;

import com.van.security.domain.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysPermissionMapper {

    public List<SysPermission> findAll();

    public List<SysPermission> findByParams(Map<String, Object> params);
}
