package com.van.security.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_permission")
public class SysPermission {

    private int id;

    private String name;

    private String description;

    private  String url;

    private int pid;

    private List<SysRole> roles;

    public SysPermission() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }


    @Transient
    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
