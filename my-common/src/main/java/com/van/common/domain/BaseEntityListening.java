package com.van.common.domain;

import com.van.common.core.AppContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class BaseEntityListening {

    @PrePersist
    public void prePersist(BaseEntity baseEntity){
        Date currentDate = new Date();
        LoginInfo info = AppContext.getInstance().getLoginInfo();

//        baseEntity.setCreateId(info.getUserId());  //合并到my-security时再启用
        baseEntity.setCreateDate(currentDate);
//        baseEntity.setLastModifyId(info.getUserId());
        baseEntity.setLastModifyDate(currentDate);
    }

    @PreUpdate
    public void preUpdate(BaseEntity baseEntity){
        Date currentDate = new Date();
        LoginInfo info = AppContext.getInstance().getLoginInfo();

//        baseEntity.setLastModifyId(info.getUserId()); //合并到my-security时再启用
        baseEntity.setLastModifyDate(currentDate);
    }
}
