package com.ironhack.erp.bookservice.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book(null, null, null, null, null, null);
    }

    @Test
    void prePersist() {
        book.prePersist();
    }

    @Test
    void getAuthor() {
        book.setAuthor("author");
        assertEquals("author", book.getAuthor());
    }

    @Test
    void getPrice() {
        book.setPrice(new BigDecimal(100));
        assertEquals(new BigDecimal(100), book.getPrice());
    }

    @Test
    void getId() {
        book.setId((long) 1);
        assertEquals(1, book.getId());
    }

    @Test
    void getName() {
        book.setName("book");
        assertEquals("book", book.getName());
    }

    @Test
    void getEan() {
        book.setEan("ean");
        assertEquals("ean", book.getEan());
    }

    @Test
    void getImg() {
        book.setImg("img");
        assertEquals("img", book.getImg());
    }

    @Test
    void getStock() {
        book.setStock(12);
        assertEquals(12, book.getStock());
    }

    @Test
    void getCreatedAt() {
        book.setCreatedAt(new Date());
        book.getCreatedAt();
    }
}