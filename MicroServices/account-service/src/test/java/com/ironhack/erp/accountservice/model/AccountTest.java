package com.ironhack.erp.accountservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account(null, null, null, false);
    }

    @Test
    void getId() {
        account.setId((long) 1);
        assertEquals(1, account.getId());
    }

    @Test
    void getOwnerId() {
        account.setOwnerId((long) 1);
        assertEquals(1, account.getOwnerId());
    }

    @Test
    void getOwnerName() {
        account.setOwnerName("name");
        assertEquals("name", account.getOwnerName());
    }

    @Test
    void getCredit() {
        account.setCredit(new BigDecimal(10));
        assertEquals(new BigDecimal(10), account.getCredit());
    }

    @Test
    void isPremium() {
        account.setPremium(true);
        assertTrue(account.isPremium());
    }

    @Test
    void getCreatedAt() {
        account.setCreatedAt(new Date());
        account.getCreatedAt();
    }
}