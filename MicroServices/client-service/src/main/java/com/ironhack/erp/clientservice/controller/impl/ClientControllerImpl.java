package com.ironhack.erp.clientservice.controller.impl;

import com.ironhack.erp.clientservice.controller.interfaces.ClientControllerInterface;
import com.ironhack.erp.clientservice.model.entities.Client;
import com.ironhack.erp.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClientControllerImpl implements ClientControllerInterface {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAll(){ return clientService.findAll();}
    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable Long id){ return clientService.findById(id);}
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){ return clientService.createClient(client);}

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }
    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){ clientService.deleteClient(id);}

    @PutMapping("/clients/{id}/{newCredit}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal newCredit) throws Exception {
        clientService.setCredit(id, newCredit);
    }

}
