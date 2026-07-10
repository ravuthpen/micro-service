package com.piseth.bank.account.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private String createDate;
}
