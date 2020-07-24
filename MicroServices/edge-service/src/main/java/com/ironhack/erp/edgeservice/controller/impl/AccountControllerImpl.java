package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.AccountControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.AccountDto;
import com.ironhack.erp.edgeservice.model.viewModel.AccountViewModel;
import com.ironhack.erp.edgeservice.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(tags = "Account Controller")
@RestController
@CrossOrigin(origins = "*")
public class AccountControllerImpl implements AccountControllerInterface {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    @ApiOperation(value="Find All Accounts",
            notes = "Lists all accounts created",
            response = AccountViewModel.class)
    public List<AccountViewModel> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}")
    @ApiOperation(value="Find Accounts by Id",
            notes = "Display account with specific Id",
            response = AccountViewModel.class)
    public AccountViewModel findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/accounts")
    @ApiOperation(value="Create New Account",
            notes = "Create a new account",
            response = AccountViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public AccountViewModel create(@RequestBody AccountDto account) {
        return accountService.create(account);
    }

    @PutMapping("/accounts/{id}")
    @ApiOperation(value="Update an Account",
            response = AccountViewModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    public AccountViewModel update(@PathVariable Long id, @RequestBody AccountDto account) {
        return accountService.update(id, account);
    }

    @DeleteMapping("/accounts/{id}")
    @ApiOperation(value="Delete an Account",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }

    @PutMapping("/accounts/{id}/credit/{credit}")
    @ApiOperation(value="Set the credit of an Account",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal credit) throws Exception {
        accountService.setCredit(id, credit);
    }

    @PutMapping("/accounts/{id}/premium/{premium}")
    @ApiOperation(value="Set the premium status of  an Account",
            response = void.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPremium(@PathVariable Long id, @PathVariable Integer premium) {
        accountService.setPremium(id, premium);
    }
}
