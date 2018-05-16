package com.van.common.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class BaseEntityListening {

    @PrePersist
    public void prePersist(BaseEntity baseEntity){
        Date currentDate = new Date();
        baseEntity.setCreateDate(currentDate);
        baseEntity.setLastModifyDate(currentDate);
    }

    @PreUpdate
    public void preUpdate(BaseEntity baseEntity){
        Date currentDate = new Date();
        baseEntity.setLastModifyDate(currentDate);
    }
}
