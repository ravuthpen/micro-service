package com.piseth.bank.account.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanResponseDTO {
    private Long loanNumber;
    private Long customerId;
    private String startDate;
    private String loanType;
    private BigDecimal totalLoan;
    private BigDecimal amountPaid;
    private BigDecimal outstandingAmount;
    private String createdDate;
    private String updatedDate;
}
