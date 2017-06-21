package com.whgb.model;

import java.math.BigDecimal;

public class FiDWallet {
    private String id;

    private String accountId;

    private BigDecimal money;

    private BigDecimal creditMoney;

    private Integer globalStateType;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(BigDecimal creditMoney) {
        this.creditMoney = creditMoney;
    }

    public Integer getGlobalStateType() {
        return globalStateType;
    }

    public void setGlobalStateType(Integer globalStateType) {
        this.globalStateType = globalStateType;
    }
}