package com.piseth.bank.message.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerMessageDTO {
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
}
