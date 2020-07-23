package com.ironhack.erp.clientservice.controller.interfaces;

import com.ironhack.erp.clientservice.model.entities.Client;

import java.math.BigDecimal;
import java.util.List;

public interface ClientControllerInterface {
    public List<Client> findAll();
    public Client findById(Long id);
    public Client createClient(Client client);
    public Client updateClient(Long id, Client client);
    public void deleteClient(Long id);
    public void setCredit(Long id, BigDecimal newCredit) throws Exception;
}
