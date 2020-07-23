package com.ironhack.erp.edgeservice.model.dto;

import java.math.BigDecimal;

public class ClientDto {
    private String name;
    private String telNumber;
    private String email;
    private String address;
    private Integer zipCode;
    private BigDecimal credit;

    public ClientDto(String name, String telNumber, String email, String address, Integer zipCode, BigDecimal credit) {
        this.name = name;
        this.telNumber = telNumber;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.credit = credit;
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
}
