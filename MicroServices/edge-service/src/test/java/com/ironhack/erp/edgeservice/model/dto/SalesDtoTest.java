package com.ironhack.erp.edgeservice.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesDtoTest {

    SalesDto salesDto;

    @BeforeEach
    void setUp() {
        salesDto = new SalesDto(null, null, null, null, null);
    }

    @Test
    void getClient() {
        salesDto.setClient((long) 1);
        assertEquals(1, salesDto.getClient());
    }

    @Test
    void getProduct() {
        salesDto.setProduct("product");
        assertEquals("product", salesDto.getProduct());
    }

    @Test
    void getPaymentMethod() {
        salesDto.setPaymentMethod("card");
        assertEquals("card", salesDto.getPaymentMethod());
    }

    @Test
    void getDiscount() {
        salesDto.setDiscount(new BigDecimal(10));
        assertEquals(new BigDecimal(10), salesDto.getDiscount());
    }

    @Test
    void getTotal() {
        salesDto.setTotal(new BigDecimal(100));
        assertEquals(new BigDecimal(100), salesDto.getTotal());
    }
}