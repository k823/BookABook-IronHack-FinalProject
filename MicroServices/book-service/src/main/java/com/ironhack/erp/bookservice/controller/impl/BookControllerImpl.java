package com.ironhack.erp.bookservice.controller.impl;

import com.ironhack.erp.bookservice.controller.interfaces.BookControllerInterface;
import com.ironhack.erp.bookservice.model.entities.Book;
import com.ironhack.erp.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BookControllerImpl implements BookControllerInterface {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createProduct(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book update(@PathVariable Long id, @RequestBody Book book) {
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
