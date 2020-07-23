package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.ClientControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import com.ironhack.erp.edgeservice.service.ClientService;
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
    public List<ClientViewModel> findAll(){ return clientService.findAll();}
    @GetMapping("/clients/{id}")
    public ClientViewModel findById(@PathVariable Long id){ return clientService.findById(id);}
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel createClient(@RequestBody ClientDto client){ return clientService.createClient(client);}

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel updateClient(@PathVariable Long id, @RequestBody ClientDto client) {
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
