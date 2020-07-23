package com.ironhack.erp.accountservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.accountservice.model.Account;
import com.ironhack.erp.accountservice.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountControllerImplTest {

    @Autowired
    AccountControllerImpl accountController;

    @MockBean
    AccountService accountService;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Account account;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        account = new Account((long) 1, "name", new BigDecimal(100), false);
        account.setId((long) 1);

        when(accountService.findAll()).thenReturn(Arrays.asList(account));
        when(accountService.findById((long) 1)).thenReturn(account);
        when(accountService.create(account)).thenReturn(account);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/accounts")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/accounts/1")).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/accounts")
                .content(objectMapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/accounts/1")
                .content(objectMapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/accounts/1")).andExpect(status().isNoContent());
    }

    @Test
    void setCredit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/accounts/1/credit/200")).andExpect(status().isNoContent());
    }

    @Test
    void setPremium() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/accounts/1/premium/1")).andExpect(status().isNoContent());
    }
}