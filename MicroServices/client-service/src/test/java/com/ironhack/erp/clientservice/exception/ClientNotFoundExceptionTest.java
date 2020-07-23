package com.ironhack.erp.clientservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientNotFoundExceptionTest {

    @Test
    void assertThrows() throws ClientNotFoundException {
        new ClientNotFoundException(null);
    }

}