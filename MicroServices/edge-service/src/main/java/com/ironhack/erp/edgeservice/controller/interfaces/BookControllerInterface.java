package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.BookDto;
import com.ironhack.erp.edgeservice.model.viewModel.BookViewModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookControllerInterface {
    public List<BookViewModel> findAll();
    public BookViewModel findById(@PathVariable Long id);
    public BookViewModel createProduct(@RequestBody BookDto book);
    public BookViewModel update(@PathVariable Long id, @RequestBody BookDto book);
    public void delete(@PathVariable Long id);
    public void setStock(@PathVariable Long id, @PathVariable Integer amount);
}
