package com.ironhack.erp.edgeservice.model.viewModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SalesViewModelTest {

    SalesViewModel salesViewModel;

    @BeforeEach
    void setUp() {
        salesViewModel = new SalesViewModel(null, null, null, null, null, null, null);
    }

    @Test
    void getId() {
        salesViewModel.setId("id");
        assertEquals("id", salesViewModel.getId());
    }

    @Test
    void getClient() {
        salesViewModel.setClient((long) 1);
        assertEquals(1, salesViewModel.getClient());
    }

    @Test
    void getProduct() {
        salesViewModel.setProduct("product");
        assertEquals("product", salesViewModel.getProduct());
    }

    @Test
    void getPaymentMethod() {
        salesViewModel.setPaymentMethod("card");
        assertEquals("card", salesViewModel.getPaymentMethod());
    }

    @Test
    void getDiscount() {
        salesViewModel.setDiscount(new BigDecimal(10));
        assertEquals(new BigDecimal(10), salesViewModel.getDiscount());
    }

    @Test
    void getTotal() {
        salesViewModel.setTotal(new BigDecimal(100));
        assertEquals(new BigDecimal(100), salesViewModel.getTotal());
    }

    @Test
    void getCreatedAt() {
        salesViewModel.setCreatedAt(new Date());
        salesViewModel.getCreatedAt();
    }
}