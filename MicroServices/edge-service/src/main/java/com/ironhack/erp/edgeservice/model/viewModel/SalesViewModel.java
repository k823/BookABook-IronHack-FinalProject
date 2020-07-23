package com.ironhack.erp.edgeservice.model.viewModel;

import java.math.BigDecimal;
import java.util.Date;

public class SalesViewModel {
    private String id;
    private Long client;
    private String product;
    private String paymentMethod;
    private BigDecimal discount;
    private BigDecimal total;
    private Date createdAt;

    public SalesViewModel(String id, Long client, String product, String paymentMethod, BigDecimal discount, BigDecimal total, Date createdAt) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
