package com.ironhack.erp.accountservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NotFoundExceptionTest {

    @Test
    void assertThrows() {
        new NotFoundException(null);

    }

}