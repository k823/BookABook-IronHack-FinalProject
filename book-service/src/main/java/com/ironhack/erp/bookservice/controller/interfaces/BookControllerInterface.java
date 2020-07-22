package com.ironhack.erp.bookservice.controller.interfaces;

import com.ironhack.erp.bookservice.model.entities.Book;

import java.util.List;

public interface BookControllerInterface {
    public List<Book> findAll();
    public Book findById(Long id);
    public Book createProduct(Book book);
    public Book update(Long id, Book book);
    public void delete(Long id);
    public void setStock(Long id, Integer amount);
}
