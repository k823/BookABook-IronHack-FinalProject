package com.ironhack.erp.salesservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaleNotFoundExceptionTest {

    @Test
    void assertThrows() throws SaleNotFoundException {
       new SaleNotFoundException(null);

    }

}