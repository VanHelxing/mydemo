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


    /**
     * Get id string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-15
     */
    @Id
    @GenericGenerator(name = "costom-uuid", strategy = "com.van.common.domain.IDGenerator")
    @GeneratedValue(generator = "costom-uuid")
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @author : yangjunqing / 2018-05-15
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get create id string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-15
     */
    @Column
    public String getCreateId() {
        return createId;
    }

    /**
     * Sets create id.
     *
     * @param createId the create id
     * @author : yangjunqing / 2018-05-15
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * Get create date date.
     *
     * @return the date
     * @author : yangjunqing / 2018-05-15
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets create date.
     *
     * @param createDate the create date
     * @author : yangjunqing / 2018-05-15
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get last modify id string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-15
     */
    @Column
    public String getLastModifyId() {
        return lastModifyId;
    }

    /**
     * Sets last modify id.
     *
     * @param lastModifyId the last modify id
     * @author : yangjunqing / 2018-05-15
     */
    public void setLastModifyId(String lastModifyId) {
        this.lastModifyId = lastModifyId;
    }

    /**
     * Get last modify date date.
     *
     * @return the date
     * @author : yangjunqing / 2018-05-15
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    /**
     * Sets last modify date.
     *
     * @param lastModifyDate the last modify date
     * @author : yangjunqing / 2018-05-15
     */
    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    /**
     * Get status string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-15
     */
    @Column
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     * @author : yangjunqing / 2018-05-15
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
