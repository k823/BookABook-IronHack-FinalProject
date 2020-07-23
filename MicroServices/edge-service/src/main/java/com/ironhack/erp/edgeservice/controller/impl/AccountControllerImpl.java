package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.AccountControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.AccountDto;
import com.ironhack.erp.edgeservice.model.viewModel.AccountViewModel;
import com.ironhack.erp.edgeservice.service.AccountService;
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
    public List<AccountViewModel> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    public AccountViewModel findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountViewModel create(@RequestBody AccountDto account) {
        return accountService.create(account);
    }

    @PutMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountViewModel update(@PathVariable Long id, @RequestBody AccountDto account) {
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
