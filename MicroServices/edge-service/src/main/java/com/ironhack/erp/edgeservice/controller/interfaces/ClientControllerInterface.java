package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface ClientControllerInterface {
    public List<ClientViewModel> findAll();
    public ClientViewModel findById(@PathVariable Long id);
    public ClientViewModel createClient(@RequestBody ClientDto client);
    public ClientViewModel updateClient(@PathVariable Long id, @RequestBody ClientDto client);
    public void deleteClient(@PathVariable Long id);
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal newCredit) throws Exception;
}
