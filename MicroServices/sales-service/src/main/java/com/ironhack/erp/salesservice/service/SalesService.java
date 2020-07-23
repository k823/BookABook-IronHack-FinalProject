package com.ironhack.erp.salesservice.service;


import com.ironhack.erp.salesservice.exception.SaleNotFoundException;
import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    public List<Sale> findAllSales(){ return salesRepository.findAll();}
    public Sale findSaleById(String id){ return salesRepository.findById(id).orElseThrow(()-> new SaleNotFoundException("Sale with id: "+ id + " not found"));}
    public Sale createSale(Sale sale){ return salesRepository.save(sale);}
    public void deleteSale(String id){ salesRepository.deleteById(id);}
}
