package com.piseth.bank.message.function;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class MessageFunctions {

    @Bean
    Function<CustomerMessageDTO, CustomerMessageDTO> email(){
        return customerMsgDTO -> {
            log.info("Sending email with this date: {}", customerMsgDTO);
            return customerMsgDTO;
        };
    }

    @Bean
    Function<CustomerMessageDTO, Long> sms(){
        return customerMsgDTO ->{
            log.info("Sending sms with this number: {}", customerMsgDTO);
            return customerMsgDTO.getCustomerId();
        };
    }
}
