package com.ironhack.erp.clientservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.clientservice.model.entities.Client;
import com.ironhack.erp.clientservice.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ClientControllerImplTest {
    @Autowired
    ClientControllerImpl clientController;

    @MockBean
    ClientRepository clientRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Client client;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        client = new Client(null, null, null, null, null, null);

        when(clientRepository.findAll()).thenReturn(Arrays.asList(client));
        when(clientRepository.findById((long) 1)).thenReturn(java.util.Optional.ofNullable(client));
        when(clientRepository.save(client)).thenReturn(client);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/clients")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/clients/1")).andExpect(status().isOk());

    }

    @Test
    void createClient() throws Exception{
        mockMvc.perform(post("/clients")
                .content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateClient() throws Exception {
        mockMvc.perform(put("/clients/1")
                .content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteClient() throws Exception {
        mockMvc.perform(delete("/clients/1")).andExpect(status().isNoContent());
    }

    @Test
    void setCredit() throws Exception {
        mockMvc.perform(put("/clients/1/100")).andExpect(status().isNoContent());
    }
}