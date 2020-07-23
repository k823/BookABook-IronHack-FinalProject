package com.ironhack.erp.bookservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookNotFoundExceptionTest {
    @Test
    void assertThrows() {
        new BookNotFoundException(null);
    }

}