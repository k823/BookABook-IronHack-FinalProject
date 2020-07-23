package com.ironhack.erp.edgeservice.model.viewModel;

import java.math.BigDecimal;
import java.util.Date;

public class AccountViewModel {
    private Long id;
    private Long ownerId;
    private String ownerName;
    private BigDecimal credit;
    private boolean isPremium;
    private Date createdAt;

    public AccountViewModel(Long id, Long ownerId, String ownerName, BigDecimal credit, boolean isPremium, Date createdAt) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.credit = credit;
        this.isPremium = isPremium;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
