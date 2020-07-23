package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.SalesControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.SalesDto;
import com.ironhack.erp.edgeservice.model.viewModel.SalesViewModel;
import com.ironhack.erp.edgeservice.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SalesControllerImpl implements SalesControllerInterface {

    @Autowired
    SalesService salesService;

    @GetMapping("/sales")
    public List<SalesViewModel> findAllSales() {
        return salesService.findAllSales();
    }

    @GetMapping("/sales/{id}")
    public SalesViewModel findSaleById(@PathVariable String id) {
        return salesService.findSaleById(id);
    }

    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesViewModel createSale(@RequestBody SalesDto sale) {
        return salesService.createSale(sale);
    }

    @DeleteMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable String id) {
        salesService.deleteSale(id);
    }
}
