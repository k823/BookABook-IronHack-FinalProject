package com.ironhack.erp.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.edgeservice.client.BookClient;
import com.ironhack.erp.edgeservice.model.dto.BookDto;
import com.ironhack.erp.edgeservice.model.viewModel.BookViewModel;
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
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BookControllerImplTest {

    @Autowired
    BookControllerImpl bookController;

    @MockBean
    BookClient bookClient;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    BookDto bookDto;
    BookViewModel bookViewModel;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        bookDto = new BookDto("book", "author", "ean", "img", new BigDecimal(100), 10);
        bookViewModel = new BookViewModel((long) 1, "book", "author", "ean", "img", new BigDecimal(100), 10, new Date());

        when(bookClient.findAll()).thenReturn(Arrays.asList(bookViewModel));
        when(bookClient.findById((long) 1)).thenReturn(bookViewModel);
        when(bookClient.createProduct(bookDto)).thenReturn(bookViewModel);
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
                .content(objectMapper.writeValueAsString(bookDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception{
        mockMvc.perform(put("/books/1")
                .content(objectMapper.writeValueAsString(bookDto))
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