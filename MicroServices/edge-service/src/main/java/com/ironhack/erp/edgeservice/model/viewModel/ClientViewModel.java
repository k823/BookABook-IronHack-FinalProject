package com.ironhack.erp.edgeservice.model.viewModel;

import java.math.BigDecimal;
import java.util.Date;

public class ClientViewModel {
    private Long id;
    private String name;
    private String telNumber;
    private String email;
    private String address;
    private Integer zipCode;
    private BigDecimal credit;
    private Date createdAt;

    public ClientViewModel(Long id, String name, String telNumber, String email, String address, Integer zipCode, BigDecimal credit, Date createdAt) {
        this.id = id;
        this.name = name;
        this.telNumber = telNumber;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.credit = credit;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
