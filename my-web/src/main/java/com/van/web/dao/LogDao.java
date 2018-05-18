package com.van.web.dao;

import com.van.common.dao.BaseDao;
import com.van.web.domain.SysOperationLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao extends BaseDao<SysOperationLog> {

}
