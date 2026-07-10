package com.piset.bank.loan.repository;

import com.piset.bank.loan.domain.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends MongoRepository<Loan, Long> {
    //Optional<Loan> findLoanNumber(Long loanNumber);
    List<Loan> findByCustomerId(Long customerId);
}
