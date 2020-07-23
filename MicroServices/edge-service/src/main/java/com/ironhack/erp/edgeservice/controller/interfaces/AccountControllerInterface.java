package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.AccountDto;
import com.ironhack.erp.edgeservice.model.viewModel.AccountViewModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface AccountControllerInterface {
    public List<AccountViewModel> findAll();
    public AccountViewModel findById(@PathVariable Long id);
    public AccountViewModel create(@RequestBody AccountDto account);
    public AccountViewModel update(@PathVariable Long id, @RequestBody AccountDto account);
    public void delete(@PathVariable Long id);
    public void setCredit(@PathVariable Long id, @PathVariable BigDecimal credit) throws Exception;
    public void setPremium(@PathVariable Long id, @PathVariable Integer premium);
}
