package com.piseth.bank.account.service;

import com.piseth.bank.account.entity.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);
    List<Account> findAll();

    Account findById(Long accountNumber);
}
