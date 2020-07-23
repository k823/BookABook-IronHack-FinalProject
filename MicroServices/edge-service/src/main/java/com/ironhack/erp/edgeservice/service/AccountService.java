package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.AccountClient;
import com.ironhack.erp.edgeservice.model.dto.AccountDto;
import com.ironhack.erp.edgeservice.model.viewModel.AccountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountClient accountClient;

    @GetMapping("/accounts")
    public List<AccountViewModel> findAll() {
        return accountClient.findAll();
    }

    @GetMapping("/accounts/{id}")
    public AccountViewModel findById(Long id) {
        return accountClient.findById(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public AccountViewModel create(AccountDto account) {
        return accountClient.create(account);
    }

    @PutMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountViewModel update(Long id, AccountDto account) {
        return accountClient.update(id, account);
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        accountClient.delete(id);
    }

    @PutMapping("/accounts/{id}/credit/{credit}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(Long id, BigDecimal credit) throws Exception {
        accountClient.setCredit(id, credit);
    }

    @PutMapping("/accounts/{id}/premium/{premium}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPremium(Long id, Integer premium) {
        accountClient.setPremium(id, premium);
    }
}
