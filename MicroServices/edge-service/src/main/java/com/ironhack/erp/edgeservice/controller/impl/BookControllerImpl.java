package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.BookControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.BookDto;
import com.ironhack.erp.edgeservice.model.viewModel.BookViewModel;
import com.ironhack.erp.edgeservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookControllerImpl implements BookControllerInterface {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookViewModel> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookViewModel findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookViewModel createProduct(@RequestBody BookDto book) {
        return bookService.createProduct(book);
    }

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookViewModel update(@PathVariable Long id, @RequestBody BookDto book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/books/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStock(@PathVariable Long id, @PathVariable Integer amount) {
        bookService.setStock(id, amount);
    }
}
