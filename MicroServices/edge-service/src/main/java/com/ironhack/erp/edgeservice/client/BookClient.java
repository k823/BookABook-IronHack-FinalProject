package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.BookDto;
import com.ironhack.erp.edgeservice.model.viewModel.BookViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "BOOKS-SERVICE", url = "https://books-bookabook.herokuapp.com")
public interface BookClient {

    @GetMapping("/books")
    public List<BookViewModel> findAll();

    @GetMapping("/books/{id}")
    public BookViewModel findById(@PathVariable Long id);

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookViewModel createProduct(@RequestBody BookDto book);

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookViewModel update(@PathVariable Long id, @RequestBody BookDto book);

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id);

    @PutMapping("/books/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStock(@PathVariable Long id, @PathVariable Integer amount);
}
