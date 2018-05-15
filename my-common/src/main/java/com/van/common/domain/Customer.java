package com.van.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    private String cusId;

    private String cusName;

    private String cusSexy;

    private String cusTel;

    public Customer() {
    }

    @Id
    @Column(name = "cus_id")
    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Column(name = "cus_name")
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Column(name = "cus_sexy")
    public String getCusSexy() {
        return cusSexy;
    }

    public void setCusSexy(String cusSexy) {
        this.cusSexy = cusSexy;
    }

    @Column(name = "cus_tel")
    public String getCusTel() {
        return cusTel;
    }

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
