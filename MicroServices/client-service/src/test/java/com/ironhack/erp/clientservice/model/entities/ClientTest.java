package com.ironhack.erp.clientservice.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientTest {

    Client client;

    @BeforeEach
    void setUp() {
        client = new Client(null, null, null, null, null, null);
    }

    @Test
    void prePersist() {
        client.prePersist();
    }

    @Test
    void getId() {
        client.setId((long) 1);
        assertEquals(1, client.getId());
    }

    @Test
    void getName() {
        client.setName("name");
        assertEquals("name", client.getName());
    }

    @Test
    void getTelNumber() {
        client.setTelNumber("number");
        assertEquals("number", client.getTelNumber());
    }

    @Test
    void getEmail() {
        client.setEmail("email");
        assertEquals("email", client.getEmail());
    }

    @Test
    void getAddress() {
        client.setAddress("address");
        assertEquals("address", client.getAddress());
    }

    @Test
    void getZipCode() {
        client.setZipCode(123);
        assertEquals(123, client.getZipCode());
    }

    @Test
    void getCredit() {
        client.setCredit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), client.getCredit());
    }

    @Test
    void getCreatedAt() {
        client.setCreatedAt(new Date());
        client.getCreatedAt();
    }
}