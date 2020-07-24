package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.ClientControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import com.ironhack.erp.edgeservice.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(value = "Client Controller")
@RestController
@CrossOrigin(origins = "*")
public class ClientControllerImpl implements ClientControllerInterface {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    @ApiOperation(value="Find all Clients",
            response = ClientViewModel.class)
    public List<ClientViewModel> findAll(){ return clientService.findAll();}
    @GetMapping("/clients/{id}")
    @ApiOperation(value="Find a Client by Id",
            response = ClientViewModel.class)
    public ClientViewModel findById(@PathVariable Long id){ return clientService.findById(id);}
    @PostMapping("/clients")
    @ApiOperation(value="Create a Client",
            response = ClientViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel createClient(@RequestBody ClientDto client){ return clientService.createClient(client);}

    @PutMapping("/clients/{id}")
    @ApiOperation(value="Update a Cient",
            response = ClientViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel updateClient(@PathVariable Long id, @RequestBody ClientDto client) {
        return clientService.updateClient(id, client);
    }
    @DeleteMapping("/clients/{id}")
    @ApiOperation(value="Delete a Client by Id",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){ clientService.deleteClient(id);}

    @PutMapping("/clients/{id}/{newCredit}")
    @ApiOperation(value="Set the credit for a Client",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal newCredit) throws Exception {
        clientService.setCredit(id, newCredit);
    }
}
