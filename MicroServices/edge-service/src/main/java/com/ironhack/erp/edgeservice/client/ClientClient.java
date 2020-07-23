package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@FeignClient("client-service")
public interface ClientClient {
    @GetMapping("/clients")
    public List<ClientViewModel> findAll();
    @GetMapping("/clients/{id}")
    public ClientViewModel findById(@PathVariable Long id);
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel createClient(@RequestBody ClientDto client);
    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel updateClient(@PathVariable Long id, @RequestBody ClientDto client);
    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id);
    @PutMapping("/clients/{id}/{newCredit}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal newCredit) throws Exception;
}
