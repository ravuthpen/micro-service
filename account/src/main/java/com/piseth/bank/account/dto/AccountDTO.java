package com.piseth.bank.account.dto;

import com.piseth.bank.account.entity.Customer;
import lombok.Data;

@Data
public class AccountDTO {
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
    private String createDate;
    private String updateDate;
}
