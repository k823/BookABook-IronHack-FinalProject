package com.ironhack.erp.salesservice.service;

import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.repository.SalesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SalesServiceTest {

    @MockBean
    SalesRepository salesRepository;

    @Autowired
    SalesService salesService;

    Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale((long) 1, "product", "card", new BigDecimal(10), new BigDecimal(10));

        when(salesRepository.findAll()).thenReturn(Arrays.asList(sale));
        when(salesRepository.findById("1")).thenReturn(java.util.Optional.ofNullable(sale));
        when(salesRepository.save(sale)).thenReturn(sale);
    }

    @Test
    void findAllSales() {
        assertEquals(1, salesService.findAllSales().size());
    }

    @Test
    void findSaleById() {
        assertEquals(sale, salesService.findSaleById("1"));
    }

    @Test
    void createSale() {
        assertEquals(sale, salesService.createSale(sale));
    }

    @Test
    void deleteSale() {
        salesService.deleteSale("1");
    }
}