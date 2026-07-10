package com.piset.bank.loan.controller;

import com.piset.bank.loan.domain.Loan;
import com.piset.bank.loan.dto.LoanDTO;
import com.piset.bank.loan.mapper.LoanMapper;
import com.piset.bank.loan.service.LoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/loans")
@AllArgsConstructor
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LoanDTO dto){
        Loan loan = loanMapper.toLoan(dto);
        loan = loanService.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @GetMapping
    public ResponseEntity<?> getLoan(){
        return ResponseEntity.ok(loanService.findAll());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerId(
            @RequestHeader("pisethbank-correlation-id") String correlationId,
            @PathVariable Long customerId){
        //log.debug("Correlation id found: {}", correlationId);
        log.debug("fetch loan detail method start");
        List<Loan> loans = loanService.getByCustomerId(customerId);
        log.debug("fetch loan detail method end");
        return ResponseEntity.ok(loans);
    }
}
