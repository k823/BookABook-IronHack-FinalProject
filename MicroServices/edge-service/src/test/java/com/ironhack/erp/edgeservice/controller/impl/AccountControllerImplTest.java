package com.ironhack.erp.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.edgeservice.client.AccountClient;
import com.ironhack.erp.edgeservice.model.dto.AccountDto;
import com.ironhack.erp.edgeservice.model.viewModel.AccountViewModel;
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
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountControllerImplTest {

    @Autowired
    AccountControllerImpl accountController;

    @MockBean
    AccountClient accountClient;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    AccountDto accountDto;
    AccountViewModel accountViewModel;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        accountDto = new AccountDto((long) 1, "name", new BigDecimal(100), false);
        accountViewModel = new AccountViewModel((long) 1, (long) 1, "name", new BigDecimal(100), false, new Date());

        when(accountClient.findAll()).thenReturn(Arrays.asList(accountViewModel));
        when(accountClient.findById((long) 1)).thenReturn(accountViewModel);
        when(accountClient.create(accountDto)).thenReturn(accountViewModel);
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
                .content(objectMapper.writeValueAsString(accountDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/accounts/1")
                .content(objectMapper.writeValueAsString(accountDto))
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