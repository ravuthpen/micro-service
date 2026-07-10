package com.piseth.bank.account.mapper;

import com.piseth.bank.account.dto.AccountDTO;
import com.piseth.bank.account.entity.Account;
import com.piseth.bank.account.entity.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AccountMapper {

    public Account toAccount(AccountDTO dto){
        Account account = new Account();
        //Customer customer = dto.getCustomer();
        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setBranchAddress(dto.getBranchAddress());
        account.setCreateDate(LocalDate.parse(dto.getCreateDate()));
        account.setUpdateDate(LocalDate.parse(dto.getUpdateDate()));
        return account;
    }
}
