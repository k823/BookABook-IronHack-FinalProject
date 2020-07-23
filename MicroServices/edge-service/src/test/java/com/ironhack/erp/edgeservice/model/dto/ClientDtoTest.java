package com.ironhack.erp.edgeservice.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientDtoTest {

    ClientDto clientDto;

    @BeforeEach
    void setUp() {
        clientDto = new ClientDto(null,null,null,null, null, null);
    }

    @Test
    void getName() {
        clientDto.setName("name");
        assertEquals("name", clientDto.getName());
    }

    @Test
    void getTelNumber() {
        clientDto.setTelNumber("666555444");
        assertEquals("666555444", clientDto.getTelNumber());
    }

    @Test
    void getEmail() {
        clientDto.setEmail("email");
        assertEquals("email", clientDto.getEmail());
    }

    @Test
    void getAddress() {
        clientDto.setAddress("address");
        assertEquals("address", clientDto.getAddress());
    }

    @Test
    void getZipCode() {
        clientDto.setZipCode(123);
        assertEquals(123, clientDto.getZipCode());
    }

    @Test
    void getCredit() {
        clientDto.setCredit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), clientDto.getCredit());
    }
}