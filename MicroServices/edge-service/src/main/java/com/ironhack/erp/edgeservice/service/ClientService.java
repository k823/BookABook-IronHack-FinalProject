package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.ClientClient;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientClient clientClient;

    @GetMapping("/clients")
    public List<ClientViewModel> findAll(){ return clientClient.findAll();}
    @GetMapping("/clients/{id}")
    public ClientViewModel findById(@PathVariable Long id){ return clientClient.findById(id);}
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel createClient(@RequestBody ClientDto client){ return clientClient.createClient(client);}
    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel updateClient(@PathVariable Long id, @RequestBody ClientDto client) {
        return clientClient.updateClient(id, client);
    }
    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){ clientClient.deleteClient(id);}

    @PutMapping("/clients/{id}/{newCredit}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal newCredit) throws Exception {
        clientClient.setCredit(id, newCredit);
    }
}
