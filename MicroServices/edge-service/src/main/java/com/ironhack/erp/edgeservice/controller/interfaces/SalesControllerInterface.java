package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.SalesDto;
import com.ironhack.erp.edgeservice.model.viewModel.SalesViewModel;

import java.util.List;

public interface SalesControllerInterface {
    public List<SalesViewModel> findAllSales();
    public SalesViewModel findSaleById(String id);
    public SalesViewModel createSale(SalesDto sale);
    public void deleteSale(String id);
}
