package com.ironhack.erp.accountservice.service;

import com.ironhack.erp.accountservice.exception.NotFoundException;
import com.ironhack.erp.accountservice.model.Account;
import com.ironhack.erp.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> findAll(){ return accountRepository.findAll();}
    public Account findById(Long id){
        return accountRepository.findById(id).orElseThrow(()-> new NotFoundException("Account with id: "+ id + " not found"));
    }
    public Account create(Account account){ return accountRepository.save(account);}
    public Account update(Long id, Account account) {
        Account target = accountRepository.findById(id).orElseThrow(()-> new NotFoundException("Account with id: "+ id + " not found"));

        target.setOwnerId(account.getOwnerId());
        target.setOwnerName(account.getOwnerName());
        target.setCredit(account.getCredit());
        target.setPremium(account.isPremium());

        return accountRepository.save(target);
    }
    public void delete(Long id){ accountRepository.deleteById(id);}

    public void setCredit(Long id, BigDecimal credit) throws Exception {
        Account target = accountRepository.findById(id).orElseThrow(()-> new NotFoundException("Account with id: "+ id + " not found"));
        if (target.getCredit().intValue() < 1) {
            throw new Exception("Operation not allowed. Not enough credit.");
        } else {
            accountRepository.save(target);
        }
    }

    public void setPremium(Long id, Integer premium) {
        Account target = accountRepository.findById(id).orElseThrow(()-> new NotFoundException("Account with id: "+ id + " not found"));

        if (premium == 1) {
            target.setPremium(true);
        } else if (premium == 0) {
            target.setPremium(false);
        } else {
            return;
        }

        accountRepository.save(target);
    }
}
