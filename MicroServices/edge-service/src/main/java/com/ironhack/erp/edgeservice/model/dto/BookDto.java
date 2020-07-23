package com.ironhack.erp.edgeservice.model.dto;

import java.math.BigDecimal;

public class BookDto {
    private String name;
    private String author;
    private String ean;
    private String img;
    private BigDecimal price;
    private Integer stock;

    public BookDto(String name, String author, String ean, String img, BigDecimal price, Integer stock) {
        this.name = name;
        this.author = author;
        this.ean = ean;
        this.img = img;
        this.price = price;
        this.stock = stock;
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
}
