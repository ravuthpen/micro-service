package com.piseth.bank.account.controller;


import com.piseth.bank.account.dto.AccountDTO;
import com.piseth.bank.account.entity.Account;
import com.piseth.bank.account.mapper.AccountMapper;
import com.piseth.bank.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountDTO dto){
        Account account = accountMapper.toAccount(dto);
        account = accountService.save(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<?> getAccount(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.findById(id));
    }


}
