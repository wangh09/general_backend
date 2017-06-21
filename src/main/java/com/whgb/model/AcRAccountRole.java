package com.whgb.model;

import java.util.Date;

public class AcRAccountRole {
    private String id;

    private String accountId;

    private Integer dicRoleType;

    private Integer globalStateType;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public Integer getDicRoleType() {
        return dicRoleType;
    }

    public void setDicRoleType(Integer dicRoleType) {
        this.dicRoleType = dicRoleType;
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
}