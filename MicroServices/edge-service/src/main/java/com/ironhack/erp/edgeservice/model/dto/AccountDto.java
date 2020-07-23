package com.ironhack.erp.edgeservice.model.dto;

import java.math.BigDecimal;

public class AccountDto {
    private Long ownerId;
    private String ownerName;
    private BigDecimal credit;
    private boolean isPremium;

    public AccountDto(Long ownerId, String ownerName, BigDecimal credit, boolean isPremium) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.credit = credit;
        this.isPremium = isPremium;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
