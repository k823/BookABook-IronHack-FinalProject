package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.AccountDto;
import com.ironhack.erp.edgeservice.model.viewModel.AccountViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "ACCOUNTS-SERVICE", url = "https://accounts-bookabook.herokuapp.com")
public interface AccountClient {
    @GetMapping("/accounts")
    public List<AccountViewModel> findAll();

    @GetMapping("/accounts/{id}")
    public AccountViewModel findById(@PathVariable Long id);

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public AccountViewModel create(@RequestBody AccountDto account);

    @PutMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountViewModel update(@PathVariable Long id, @RequestBody AccountDto account);

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id);

    @PutMapping("/accounts/{id}/credit/{credit}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal credit) throws Exception;

    @PutMapping("/accounts/{id}/premium/{premium}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPremium(@PathVariable Long id, @PathVariable Integer premium);
}
