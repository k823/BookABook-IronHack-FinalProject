package com.ironhack.erp.accountservice.service;

import com.ironhack.erp.accountservice.model.Account;
import com.ironhack.erp.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account((long) 1, "name", new BigDecimal(100), false);
        account.setId((long) 1);

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account));
        when(accountRepository.findById((long) 1)).thenReturn(java.util.Optional.ofNullable(account));
        when(accountRepository.save(account)).thenReturn(account);
    }

    @Test
    void findAll() {
        assertEquals(1, accountService.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(account, accountService.findById((long) 1));
    }

    @Test
    void create() {
        assertEquals(account, accountService.create(account));
    }

    @Test
    void update() {
        assertEquals(account, accountService.update((long) 1, account));
    }

    @Test
    void delete() {
        accountService.delete((long) 1);
    }

    @Test
    void setCredit() throws Exception {
        accountService.setCredit((long) 1, new BigDecimal(100));
        assertThrows(Exception.class, () -> accountService.setCredit((long) 1, new BigDecimal(-400)));
    }

    @Test
    void setPremium() {
        accountService.setPremium((long) 1, 0);
        accountService.setPremium((long) 1, 1);
        accountService.setPremium((long) 1, 2);
    }
}