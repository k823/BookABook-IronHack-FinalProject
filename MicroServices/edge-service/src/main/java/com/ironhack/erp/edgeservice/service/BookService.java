package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.BookClient;
import com.ironhack.erp.edgeservice.model.dto.BookDto;
import com.ironhack.erp.edgeservice.model.viewModel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookClient bookClient;

    public List<BookViewModel> findAll() {
        return bookClient.findAll();
    }

    public BookViewModel findById(Long id) {
        return bookClient.findById(id);
    }

    public BookViewModel createProduct(BookDto book) {
        return bookClient.createProduct(book);
    }

    public BookViewModel update(Long id, BookDto book) {
        return bookClient.update(id, book);
    }

    public void delete(Long id) {
        bookClient.delete(id);
    }

    public void setStock(Long id, Integer amount) {
        bookClient.setStock(id, amount);
    }
}
