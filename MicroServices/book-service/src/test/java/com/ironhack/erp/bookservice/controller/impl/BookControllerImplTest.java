package com.ironhack.erp.bookservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.bookservice.model.entities.Book;
import com.ironhack.erp.bookservice.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BookControllerImplTest {

    @Autowired
    BookControllerImpl bookController;

    @MockBean
    BookRepository bookRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Book book;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        book = new Book("book", "author", "ean", "img", new BigDecimal(100), 10);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        when(bookRepository.findById((long) 1)).thenReturn(java.util.Optional.ofNullable(book));
        when(bookRepository.save(book)).thenReturn(book);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/books")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/books/1")).andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {
        mockMvc.perform(post("/books")
                .content(objectMapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception{
        mockMvc.perform(put("/books/1")
                .content(objectMapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1")).andExpect(status().isNoContent());
    }

    @Test
    void setStock() throws Exception {
        mockMvc.perform(put("/books/1/5")).andExpect(status().isNoContent());
    }
}