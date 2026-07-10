package com.piset.bank.loan.service.impl;

import com.piset.bank.loan.domain.Loan;
import com.piset.bank.loan.repository.LoanRepository;
import com.piset.bank.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

//    @Override
//    public Optional<Loan> findLoanNumber(Long loanNumber) {
//        return loanRepository.findLoanNumber(loanNumber);
//
//    }



}
