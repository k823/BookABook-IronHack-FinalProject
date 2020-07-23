package com.ironhack.erp.bookservice.service;

import com.ironhack.erp.bookservice.exception.BookNotFoundException;
import com.ironhack.erp.bookservice.model.entities.Book;
import com.ironhack.erp.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book with id: "+ id + " not found"));
    }
    public Book create(Book book){
        return bookRepository.save(book);
    }
    public Book update(Long id, Book book) {
        Book target = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book with id: "+ id + " not found"));

        target.setName(book.getName());
        target.setAuthor(book.getAuthor());
        target.setEan(book.getEan());
        target.setImg(book.getImg());
        target.setPrice(book.getPrice());
        target.setStock(book.getStock());

        return bookRepository.save(target);
    }
    public void delete(Long id){
        bookRepository.deleteById(id);
    }
    public void setStock(Long id, Integer amount) {
        Book target = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book with id: "+ id + " not found"));
        target.setStock(target.getStock()+amount);
        bookRepository.save(target);
    }

}
