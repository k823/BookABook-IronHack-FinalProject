package com.ironhack.erp.clientservice.service;

import com.ironhack.erp.clientservice.exception.ClientNotFoundException;
import com.ironhack.erp.clientservice.model.entities.Client;
import com.ironhack.erp.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(()-> new ClientNotFoundException("Client with id: "+ id + " not found"));
    }
    public Client createClient(Client client){
        return clientRepository.save(client);
    }
    public Client updateClient(Long id, Client client) {
        Client target = clientRepository.findById(id).orElseThrow(()-> new ClientNotFoundException("Client with id: "+ id + " not found"));

        target.setName(client.getName());
        target.setEmail(client.getEmail());
        target.setTelNumber(client.getTelNumber());
        target.setAddress(client.getAddress());
        target.setZipCode(client.getZipCode());
        target.setCredit(client.getCredit());

        return clientRepository.save(client);
    }
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

    public void setCredit(Long id, BigDecimal newCredit) throws Exception {
        Client target = clientRepository.findById(id).orElseThrow(()-> new ClientNotFoundException("Client with id: "+ id + " not found"));

        target.setCredit(newCredit);

        if (target.getCredit().intValue() < 1) {
            throw new Exception("Operation not allowed. Not enough credit.");
        } else {
            clientRepository.save(target);
        }
    }

}
