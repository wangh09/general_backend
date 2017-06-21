package com.whgb.model;

import java.math.BigDecimal;
import java.util.Date;

public class FiDCredit {
    private String id;

    private String walletId;

    private Integer dicCreditType;

    private BigDecimal amount;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Integer globalStateType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId == null ? null : walletId.trim();
    }

    public Integer getDicCreditType() {
        return dicCreditType;
    }

    public void setDicCreditType(Integer dicCreditType) {
        this.dicCreditType = dicCreditType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getGlobalStateType() {
        return globalStateType;
    }

    public void setGlobalStateType(Integer globalStateType) {
        this.globalStateType = globalStateType;
    }
}