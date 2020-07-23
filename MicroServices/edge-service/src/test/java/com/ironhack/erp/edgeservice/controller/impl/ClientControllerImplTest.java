package com.ironhack.erp.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.edgeservice.client.ClientClient;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
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
    ClientClient clientClient;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    ClientDto clientDto;
    ClientViewModel clientViewModel;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        clientDto = new ClientDto(null, null, null, null, null, null);

        when(clientClient.findAll()).thenReturn(Arrays.asList(clientViewModel));
        when(clientClient.findById((long) 1)).thenReturn(clientViewModel);
        when(clientClient.createClient(clientDto)).thenReturn(clientViewModel);
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
                .content(objectMapper.writeValueAsString(clientDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateClient() throws Exception {
        mockMvc.perform(put("/clients/1")
                .content(objectMapper.writeValueAsString(clientDto))
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