package com.van.common.domain;

import com.van.common.util.IDUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;

/**
 * 自定义主键生成方式
 */
public class IDGenerator extends HibernateDaoSupport implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        if (object == null){
            throw new IllegalArgumentException("实体类不能为空！");
        }

        if (!(object instanceof BaseEntity)){
            throw new IllegalArgumentException("实体类必须继承BaseEntity！");
        }

        // 新增
        if (((BaseEntity) object).getId() == null){
            return IDUtil.uuid();
        }
        // 更新
        else{
            return ((BaseEntity) object).getId();
        }

    }
}
