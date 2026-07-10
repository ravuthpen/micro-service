package com.piseth.bank.account.function;

import com.piseth.bank.account.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class AccountFunction {

    @Bean
    Consumer<Long> updateCustomerCommunication(CustomerService customerService){
        return customerId ->{
            customerService.updateCustomerCommunication(customerId);
            log.info("Update customer communication with customerId: {}", customerId);
        };
    }

}
