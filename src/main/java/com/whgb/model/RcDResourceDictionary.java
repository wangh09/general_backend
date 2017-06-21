package com.whgb.model;

import java.util.Date;

public class RcDResourceDictionary {
    private Integer id;

    private Integer pid;

    private String code;

    private String name;

    private Integer globalDataType;

    private Integer globalStateType;

    private Date createTime;

    private Date updateTime;

    private String codeClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGlobalDataType() {
        return globalDataType;
    }

    public void setGlobalDataType(Integer globalDataType) {
        this.globalDataType = globalDataType;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass == null ? null : codeClass.trim();
    }
}