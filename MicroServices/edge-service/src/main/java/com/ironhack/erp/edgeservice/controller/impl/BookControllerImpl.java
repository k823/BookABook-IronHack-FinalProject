package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.BookControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.BookDto;
import com.ironhack.erp.edgeservice.model.viewModel.BookViewModel;
import com.ironhack.erp.edgeservice.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Books Controller")
@RestController
@CrossOrigin(origins = "*")
public class BookControllerImpl implements BookControllerInterface {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    @ApiOperation(value="Find all Books",
            response = BookViewModel.class)
    @ResponseStatus(HttpStatus.OK)
    public List<BookViewModel> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    @ApiOperation(value="Find a Books by Id",
            response = BookViewModel.class)
    @ResponseStatus(HttpStatus.OK)
    public BookViewModel findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    @ApiOperation(value="Post a Book",
            response = BookViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public BookViewModel createProduct(@RequestBody BookDto book) {
        return bookService.createProduct(book);
    }

    @PutMapping("/books/{id}")
    @ApiOperation(value="Update a Book",
            response = BookViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public BookViewModel update(@PathVariable Long id, @RequestBody BookDto book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/books/{id}")
    @ApiOperation(value="Delete a Book by Id",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/books/{id}/{amount}")
    @ApiOperation(value="Set the stock for a Book",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStock(@PathVariable Long id, @PathVariable Integer amount) {
        bookService.setStock(id, amount);
    }
}
