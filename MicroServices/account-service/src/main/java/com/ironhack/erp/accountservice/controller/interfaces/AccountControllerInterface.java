package com.ironhack.erp.accountservice.controller.interfaces;

import com.ironhack.erp.accountservice.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountControllerInterface {
    public List<Account> findAll();
    public Account findById(Long id);
    public Account create(Account account);
    public Account update(Long id, Account account);
    public void delete(Long id);
    public void setCredit(Long id, BigDecimal credit) throws Exception;
    public void setPremium(Long id, Integer premium);
}
