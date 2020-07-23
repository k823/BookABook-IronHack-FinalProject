package com.ironhack.erp.salesservice.controller.impl;

import com.ironhack.erp.salesservice.controller.interfaces.SalesControllerInterface;
import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SalesControllerImpl implements SalesControllerInterface{
    @Autowired
    SalesService salesService;

    @GetMapping("/sales")
    public List<Sale> findAllSales() {
        return salesService.findAllSales();
    }

    @GetMapping("/sales/{id}")
    public Sale findSaleById(@PathVariable String id) {
        return salesService.findSaleById(id);
    }

    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public Sale createSale(@RequestBody Sale sale) {
        return salesService.createSale(sale);
    }

    @DeleteMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable String id) {
        salesService.deleteSale(id);
    }
}
