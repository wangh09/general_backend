package com.whgb.model;

import java.util.Date;

public class AcDAccount {
    private String id;

    private String account;

    private String phone;

    private String email;

    private String passwd;

    private Integer dicDefaultRoleType;

    private String name;

    private Integer dicSexType;

    private Integer dicIdType;

    private Integer idNumber;

    private Integer globalStateType;

    private Date createTime;

    private Date lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getDicDefaultRoleType() {
        return dicDefaultRoleType;
    }

    public void setDicDefaultRoleType(Integer dicDefaultRoleType) {
        this.dicDefaultRoleType = dicDefaultRoleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDicSexType() {
        return dicSexType;
    }

    public void setDicSexType(Integer dicSexType) {
        this.dicSexType = dicSexType;
    }

    public Integer getDicIdType() {
        return dicIdType;
    }

    public void setDicIdType(Integer dicIdType) {
        this.dicIdType = dicIdType;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getGlobalStateType() {
        return globalStateType;
    }

    public void setGlobalStateType(Integer globalStateType) {
        this.globalStateType = globalStateType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}