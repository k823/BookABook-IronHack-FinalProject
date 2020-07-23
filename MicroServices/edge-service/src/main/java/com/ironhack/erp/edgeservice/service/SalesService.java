package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.SalesClient;
import com.ironhack.erp.edgeservice.model.dto.SalesDto;
import com.ironhack.erp.edgeservice.model.viewModel.SalesViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    SalesClient salesClient;

    public List<SalesViewModel> findAllSales() {
        return salesClient.findAllSales();
    }

    public SalesViewModel findSaleById(String id) {
        return salesClient.findSaleById(id);
    }

    public SalesViewModel createSale(SalesDto sale) {
        return salesClient.createSale(sale);
    }

    public void deleteSale(String id) {
        salesClient.deleteSale(id);
    }
}
