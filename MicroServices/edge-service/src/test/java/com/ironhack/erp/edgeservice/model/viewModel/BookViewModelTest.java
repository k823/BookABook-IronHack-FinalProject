package com.ironhack.erp.edgeservice.model.viewModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookViewModelTest {

    BookViewModel bookViewModel;

    @BeforeEach
    void setUp() {
        bookViewModel = new BookViewModel(null, null, null, null, null, null, null, null);
    }

    @Test
    void getId() {
        bookViewModel.setId((long) 1);
        assertEquals(1, bookViewModel.getId());
    }

    @Test
    void getName() {
        bookViewModel.setName("book");
        assertEquals("book", bookViewModel.getName());
    }

    @Test
    void getAuthor() {
        bookViewModel.setAuthor("author");
        assertEquals("author", bookViewModel.getAuthor());
    }

    @Test
    void getEan() {
        bookViewModel.setEan("ean");
        assertEquals("ean", bookViewModel.getEan());
    }

    @Test
    void getImg() {
        bookViewModel.setImg("img");
        assertEquals("img", bookViewModel.getImg());
    }

    @Test
    void getPrice() {
        bookViewModel.setPrice(new BigDecimal(100));
        assertEquals(new BigDecimal(100), bookViewModel.getPrice());
    }

    @Test
    void getStock() {
        bookViewModel.setStock(10);
        assertEquals(10, bookViewModel.getStock());
    }

    @Test
    void getCreatedAt() {
        bookViewModel.setCreatedAt(new Date());
        bookViewModel.getCreatedAt();
    }
}