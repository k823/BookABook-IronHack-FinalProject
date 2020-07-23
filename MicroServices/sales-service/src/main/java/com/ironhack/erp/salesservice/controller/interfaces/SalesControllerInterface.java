package com.ironhack.erp.salesservice.controller.interfaces;

import com.ironhack.erp.salesservice.exception.SaleNotFoundException;
import com.ironhack.erp.salesservice.model.entities.Sale;

import java.util.List;

public interface SalesControllerInterface {
    public List<Sale> findAllSales();
    public Sale findSaleById(String id);
    public Sale createSale(Sale sale);
    public void deleteSale(String id);
}
