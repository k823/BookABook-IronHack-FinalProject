package com.ironhack.erp.accountservice.controller.impl;

import com.ironhack.erp.accountservice.controller.interfaces.AccountControllerInterface;
import com.ironhack.erp.accountservice.model.Account;
import com.ironhack.erp.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AccountControllerImpl implements AccountControllerInterface {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account update(@PathVariable Long id, @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }

    @PutMapping("/accounts/{id}/credit/{credit}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal credit) throws Exception {
        accountService.setCredit(id, credit);
    }

    @PutMapping("/accounts/{id}/premium/{premium}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPremium(@PathVariable Long id, @PathVariable Integer premium) {
        accountService.setPremium(id, premium);
    }
}
