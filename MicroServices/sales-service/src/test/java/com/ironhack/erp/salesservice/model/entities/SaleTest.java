package com.ironhack.erp.salesservice.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaleTest {

    Sale sale;
    @BeforeEach
    void setUp() {
        sale = new Sale(null, null, null, null, null);
    }

    @Test
    void getId() {
        sale.setId("1");
        assertEquals("1", sale.getId());
    }

    @Test
    void getClient() {
        sale.setClient((long) 1);
        assertEquals(1, sale.getClient());
    }

    @Test
    void getProduct() {
        sale.setProduct("product");
        assertEquals("product", sale.getProduct());
    }

    @Test
    void getPaymentMethod() {
        sale.setPaymentMethod("card");
        assertEquals("card", sale.getPaymentMethod());
    }

    @Test
    void getDiscount() {
        sale.setDiscount(new BigDecimal(10));
        assertEquals(new BigDecimal(10), sale.getDiscount());
    }

    @Test
    void getTotal() {
        sale.setTotal(new BigDecimal(100));
        assertEquals(new BigDecimal(100), sale.getTotal());
    }

    @Test
    void getCreatedAt() {
        sale.setCreatedAt(new Date());
        sale.getCreatedAt();
    }
}