package com.ironhack.erp.salesservice.repository;

import com.ironhack.erp.salesservice.model.entities.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends MongoRepository<Sale, String> {
}
