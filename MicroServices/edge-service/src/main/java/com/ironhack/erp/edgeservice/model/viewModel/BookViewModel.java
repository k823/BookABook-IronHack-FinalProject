package com.ironhack.erp.edgeservice.model.viewModel;

import java.math.BigDecimal;
import java.util.Date;

public class BookViewModel {
    private Long id;
    private String name;
    private String author;
    private String ean;
    private String img;
    private BigDecimal price;
    private Integer stock;
    private Date createdAt;

    public BookViewModel(Long id, String name, String author, String ean, String img, BigDecimal price, Integer stock, Date createdAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.ean = ean;
        this.img = img;
        this.price = price;
        this.stock = stock;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
