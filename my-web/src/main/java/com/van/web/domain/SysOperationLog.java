package com.van.web.domain;

import com.van.common.domain.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统操作日志
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Entity
@Table(name = "sys_operation_log")
@DynamicInsert  //只保存有值的
@DynamicUpdate  //只保存修改的
public class SysOperationLog extends BaseEntity {

    /**
     * 访问路径
     */
    private String url;

    /**
     * 访问方式
     * <ul>
     *     <li>System</li>
     *     <li>Api</li>
     * </ul>
     */
    private String type;

    /**
     * 模块
     */
    private String module;

    /**
     * 操作方式
     */
    private String method;

    /**
     * 提交的数据
     */
    private String data;

    /**
     * 访问端IP
     */
    private String remoteIP;

    /**
     * 用户编号
     */
    private String userId;


    /**
     * Get url string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     * @author : yangjunqing / 2018-05-17
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get method string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    @Column(name = "method")
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     * @author : yangjunqing / 2018-05-17
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Get data string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    @Column(name = "data")
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     * @author : yangjunqing / 2018-05-17
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Get remote ip string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    @Column(name = "remote_ip")
    public String getRemoteIP() {
        return remoteIP;
    }

    /**
     * Sets remote ip.
     *
     * @param remoteIP the remote ip
     * @author : yangjunqing / 2018-05-17
     */
    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    /**
     * Get user id string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     * @author : yangjunqing / 2018-05-17
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "module")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
