package com.piset.bank.loan.service;

import com.piset.bank.loan.domain.Loan;

import java.util.List;
import java.util.Optional;


public interface LoanService {
    Loan save(Loan loan);
    List<Loan> findAll();

    List<Loan> getByCustomerId(Long customerId);
}
