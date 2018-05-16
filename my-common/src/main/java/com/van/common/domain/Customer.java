package com.van.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    /**
     * 客户编号
     */
    private String cusId;

    /**
     * 客户姓名
     */
    private String cusName;

    /**
     * 客户性别
     */
    private String cusSexy;

    /**
     * 客户电话
     */
    private String cusTel;

    public Customer() {
    }

    /**
     * Get cus id string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-16
     */
    @Column(name = "cus_id")
    public String getCusId() {
        return cusId;
    }

    /**
     * Sets cus id.
     *
     * @param cusId the cus id
     * @author : yangjunqing / 2018-05-16
     */
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    /**
     * Get cus name string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-16
     */
    @Column(name = "cus_name")
    public String getCusName() {
        return cusName;
    }

    /**
     * Sets cus name.
     *
     * @param cusName the cus name
     * @author : yangjunqing / 2018-05-16
     */
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    /**
     * Get cus sexy string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-16
     */
    @Column(name = "cus_sexy")
    public String getCusSexy() {
        return cusSexy;
    }

    /**
     * Sets cus sexy.
     *
     * @param cusSexy the cus sexy
     * @author : yangjunqing / 2018-05-16
     */
    public void setCusSexy(String cusSexy) {
        this.cusSexy = cusSexy;
    }

    /**
     * Get cus tel string.
     *
     * @return the string
     * @author : yangjunqing / 2018-05-16
     */
    @Column(name = "cus_tel")
    public String getCusTel() {
        return cusTel;
    }

    /**
     * Sets cus tel.
     *
     * @param cusTel the cus tel
     * @author : yangjunqing / 2018-05-16
     */
    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusSexy='" + cusSexy + '\'' +
                ", cusTel='" + cusTel + '\'' +
                '}';
    }
}
