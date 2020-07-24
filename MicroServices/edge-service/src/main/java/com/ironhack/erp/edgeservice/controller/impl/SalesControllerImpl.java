package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.SalesControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.SalesDto;
import com.ironhack.erp.edgeservice.model.viewModel.SalesViewModel;
import com.ironhack.erp.edgeservice.service.SalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Sales Controller")
@RestController
@CrossOrigin(origins = "*")
public class SalesControllerImpl implements SalesControllerInterface {

    @Autowired
    SalesService salesService;

    @GetMapping("/sales")
    @ApiOperation(value="Find all Sales",
            response = SalesViewModel.class)
    public List<SalesViewModel> findAllSales() {
        return salesService.findAllSales();
    }

    @GetMapping("/sales/{id}")
    @ApiOperation(value="Find a Sale by Id",
            response = SalesViewModel.class)
    public SalesViewModel findSaleById(@PathVariable String id) {
        return salesService.findSaleById(id);
    }

    @PostMapping("/sales")
    @ApiOperation(value="Post new Sale",
            response = SalesViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public SalesViewModel createSale(@RequestBody SalesDto sale) {
        return salesService.createSale(sale);
    }

    @DeleteMapping("/sales/{id}")
    @ApiOperation(value="Delete a Sale",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable String id) {
        salesService.deleteSale(id);
    }
}
