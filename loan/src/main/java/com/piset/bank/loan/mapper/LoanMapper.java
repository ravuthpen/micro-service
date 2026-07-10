package com.piset.bank.loan.mapper;

import com.piset.bank.loan.domain.Loan;
import com.piset.bank.loan.dto.LoanDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoanMapper {

    public Loan toLoan(LoanDTO dto){
        Loan loan = new Loan();
        loan.setLoanNumber(dto.getLoanNumber());
        loan.setCustomerId(dto.getCustomerId());
        loan.setStartDate(LocalDate.parse(dto.getStartDate()));
        loan.setLoanType(dto.getLoanType());
        loan.setTotalLoan(dto.getTotalLoan());
        loan.setAmountPaid(dto.getAmountPaid());
        loan.setOutstandingAmount(dto.getOutstandingAmount());
        loan.setCreatedDate(LocalDate.parse(dto.getCreatedDate()));
        loan.setUpdatedDate(LocalDate.parse(dto.getUpdatedDate()));
        return loan;
    }

}
