package com.van.common.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@MappedSuperclass
@EntityListeners({BaseEntityListening.class})  //监听回调
public class BaseEntity implements Serializable {


    /**
     * Id
     */
    private String id;

    /**
     * 新建人
     */
    private String createId;

    /**
     * 新建日期
     */
    private Date createDate;

    /**
     * 最后一次修改人
     */
    private String lastModifyId;

    /**
     * 最后一次修改日期
     */
    private Date lastModifyDate;

    /**
     * 状态（0 - 未启用, 1 - 已启用, 2 - 已审核, 8 - 已终止, 9 - 已作废）
     */
    private String status;


    @Id
    @GenericGenerator(name = "costom-uuid", strategy = "com.van.common.domain.IDGenerator")
    @GeneratedValue(generator = "costom-uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column
    public String getLastModifyId() {
        return lastModifyId;
    }

    public void setLastModifyId(String lastModifyId) {
        this.lastModifyId = lastModifyId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    @Column
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
