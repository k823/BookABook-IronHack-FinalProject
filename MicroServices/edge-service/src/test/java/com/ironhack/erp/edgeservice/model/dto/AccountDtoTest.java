package com.ironhack.erp.edgeservice.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountDtoTest {

    AccountDto accountDto;

    @BeforeEach
    void setUp() {
        accountDto = new AccountDto(null, null, null, false);
    }

    @Test
    void getOwnerId() {
        accountDto.setOwnerId((long) 1);
        assertEquals(1, accountDto.getOwnerId());
    }

    @Test
    void getOwnerName() {
        accountDto.setOwnerName("name");
        assertEquals("name", accountDto.getOwnerName());
    }

    @Test
    void getCredit() {
        accountDto.setCredit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), accountDto.getCredit());
    }

    @Test
    void isPremium() {
        accountDto.setPremium(true);
        assertTrue(accountDto.isPremium());
    }
}