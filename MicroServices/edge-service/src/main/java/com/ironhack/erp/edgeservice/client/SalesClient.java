package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.SalesDto;
import com.ironhack.erp.edgeservice.model.viewModel.SalesViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("sales-service")
public interface SalesClient {
    @GetMapping("/sales")
    public List<SalesViewModel> findAllSales();

    @GetMapping("/sales/{id}")
    public SalesViewModel findSaleById(@PathVariable String id);

    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesViewModel createSale(@RequestBody SalesDto sale);

    @DeleteMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable String id);
}
