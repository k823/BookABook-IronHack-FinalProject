package com.ironhack.erp.edgeservice.model.viewModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AccountViewModelTest {

    AccountViewModel accountViewModel;

    @BeforeEach
    void setUp() {
        accountViewModel = new AccountViewModel(null, null, null, null,false, null);
    }

    @Test
    void getId() {
        accountViewModel.setId((long) 1);
        assertEquals(1, accountViewModel.getId());
    }

    @Test
    void getOwnerId() {
        accountViewModel.setOwnerId((long) 1);
        assertEquals(1, accountViewModel.getOwnerId());
    }

    @Test
    void getOwnerName() {
        accountViewModel.setOwnerName("name");
        assertEquals("name", accountViewModel.getOwnerName());
    }

    @Test
    void getCredit() {
        accountViewModel.setCredit(new BigDecimal(100));
        assertEquals(new BigDecimal(100), accountViewModel.getCredit());
    }

    @Test
    void isPremium() {
        accountViewModel.setPremium(true);
        assertTrue(accountViewModel.isPremium());
    }


    @Test
    void getCreatedAt() {
        accountViewModel.setCreatedAt(new Date());
        accountViewModel.getCreatedAt();
    }
}