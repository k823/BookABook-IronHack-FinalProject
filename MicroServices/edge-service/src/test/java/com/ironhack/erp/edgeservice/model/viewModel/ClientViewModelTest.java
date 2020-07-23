package com.ironhack.erp.edgeservice.model.viewModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientViewModelTest {

    ClientViewModel clientViewModel;

    @BeforeEach
    void setUp() {
        clientViewModel = new ClientViewModel(null, null, null, null, null, null, null, null);
    }

    @Test
    void getId() {
        clientViewModel.setId((long) 1);
        assertEquals(1, clientViewModel.getId());
    }

    @Test
    void getName() {
        clientViewModel.setName("name");
        assertEquals("name", clientViewModel.getName());
    }

    @Test
    void getTelNumber() {
        clientViewModel.setTelNumber("666555444");
        assertEquals("666555444", clientViewModel.getTelNumber());
    }

    @Test
    void getEmail() {
        clientViewModel.setEmail("email");
        assertEquals("email", clientViewModel.getEmail());
    }

    @Test
    void getAddress() {
        clientViewModel.setAddress("address");
        assertEquals("address", clientViewModel.getAddress());
    }

    @Test
    void getZipCode() {
        clientViewModel.setZipCode(123);
        assertEquals(123, clientViewModel.getZipCode());
    }

    @Test
    void getCredit() {
        clientViewModel.setCredit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), clientViewModel.getCredit());
    }

    @Test
    void getCreatedAt() {
        clientViewModel.setCreatedAt(new Date());
        clientViewModel.getCreatedAt();
    }
}