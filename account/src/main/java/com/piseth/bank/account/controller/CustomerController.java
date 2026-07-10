package com.piseth.bank.account.controller;

import com.piseth.bank.account.dto.*;
import com.piseth.bank.account.entity.Customer;
import com.piseth.bank.account.mapper.CustomerMapper;
import com.piseth.bank.account.service.CustomerService;
import com.piseth.bank.account.service.client.CardFeignClient;
import com.piseth.bank.account.service.client.LoanFeignClient;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    private final CardFeignClient cardFeignClient;
    private final LoanFeignClient loanFeignClient;


    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto){
        Customer customer = customerMapper.toCustomer(dto);
         customer = customerService.save(customer);
         return ResponseEntity.ok(customer);
    }


    @GetMapping
    public ResponseEntity<?> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomer()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        return  ResponseEntity.ok(customerService.getById(id));
    }

    //@CircuitBreaker(name = "customerDetailSupport", fallbackMethod = "getCustomerDetailDefault")
    //@Retry(name = "retryCustomerDetail", fallbackMethod = "getCustomerDetailDefault")
    @GetMapping("customerDetail/{customerId}")
    public ResponseEntity<CustomerDetailDTO> getCustomerDetail(
            @RequestHeader("pisethbank-correlation-id") String correlationId,
            @PathVariable Long customerId){

        //log.debug("Correlation id found: {}", correlationId);
        log.debug("fetch customer detail method start");

        CustomerDetailDTO dto  = new CustomerDetailDTO();
        Customer customer = customerService.getById(customerId);
        if(customer == null){
            throw new RuntimeException("No customer found with this id");
        }
        CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);

        List<LoanResponseDTO> loanInfo = loanFeignClient.getLoaInfo(correlationId, customerId);
        List<CardResponseDTO> cardInfo = cardFeignClient.getCardInfo(correlationId, customerId);

        dto.setCustomer(customerDTO);
        dto.setLoans(loanInfo);
        dto.setCards(cardInfo);

        log.debug("fetch customer detail method end");
        return ResponseEntity.ok(dto);
    }
    public ResponseEntity<CustomerDetailDTO> getCustomerDetailDefault(
            @RequestHeader("pisethbank-correlation-id") String correlationId,
            @PathVariable Long customerId, Throwable e){

        //log.debug("Correlation id found: {}", correlationId);
        CustomerDetailDTO dto  = new CustomerDetailDTO();
        Customer customer = customerService.getById(customerId);
        if(customer == null){
            throw new RuntimeException("No customer found with this id");
        }
        CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);
        dto.setCustomer(customerDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/sayHello")
    @RateLimiter(name = "sayHelloLimiter", fallbackMethod = "sayHi")
    public String sayHello(){
        return "Hello, Welcome to PisethBank!";
    }
    public String sayHi(Throwable t){
        return "Hi, Welcome to PisethBank!";
    }
}
