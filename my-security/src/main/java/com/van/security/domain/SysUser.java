package com.van.security.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class SysUser {

    private int id;

    private String userName;

    private String password;

    private String orgId;

    private String depId;

    private List<SysRole> roles;

    public SysUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "org_id")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "dep_id ")
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Transient
    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", orgId='" + orgId + '\'' +
                ", depId='" + depId + '\'' +
                ", roles=" + roles +
                '}';
    }
}
