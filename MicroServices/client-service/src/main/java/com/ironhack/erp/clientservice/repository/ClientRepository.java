package com.ironhack.erp.clientservice.repository;

import com.ironhack.erp.clientservice.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
