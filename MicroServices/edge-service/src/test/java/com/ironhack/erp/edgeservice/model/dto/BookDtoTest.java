package com.ironhack.erp.edgeservice.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDtoTest {

    BookDto bookDto;

    @BeforeEach
    void setUp() {
        bookDto = new BookDto(null, null, null, null, null, null);
    }

    @Test
    void getName() {
        bookDto.setName("book");
        assertEquals("book", bookDto.getName());
    }

    @Test
    void getAuthor() {
        bookDto.setAuthor("author");
        assertEquals("author", bookDto.getAuthor());
    }

    @Test
    void getEan() {
        bookDto.setEan("ean");
        assertEquals("ean", bookDto.getEan());
    }

    @Test
    void getImg() {
        bookDto.setImg("img");
        assertEquals("img", bookDto.getImg());
    }

    @Test
    void getPrice() {
        bookDto.setPrice(new BigDecimal(100));
        assertEquals(new BigDecimal(100), bookDto.getPrice());
    }

    @Test
    void getStock() {
        bookDto.setStock(10);
        assertEquals(10, bookDto.getStock());
    }
}