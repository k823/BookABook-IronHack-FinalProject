package com.ironhack.erp.salesservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.service.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SalesControllerImplTest {

    @MockBean
    SalesService salesService;

    @Autowired
    SalesControllerImpl salesController;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Sale sale;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        sale = new Sale((long) 1, "product", "card", new BigDecimal(10), new BigDecimal(10));

        when(salesService.findAllSales()).thenReturn(Arrays.asList(sale));
        when(salesService.findSaleById("1")).thenReturn(sale);
        when(salesService.createSale(sale)).thenReturn(sale);
    }

    @Test
    void findAllSales() throws Exception {
        mockMvc.perform(get("/sales")).andExpect(status().isOk());
    }

    @Test
    void findSaleById() throws Exception {
        mockMvc.perform(get("/sales/1")).andExpect(status().isOk());
    }

    @Test
    void createSale() throws Exception {
        mockMvc.perform(post("/sales")
                .content(objectMapper.writeValueAsString(sale))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteSale() throws Exception {
        mockMvc.perform(delete("/sales/1")).andExpect(status().isNoContent());
    }
}