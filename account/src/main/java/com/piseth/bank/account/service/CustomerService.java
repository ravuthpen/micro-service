package com.piseth.bank.account.service;

import com.piseth.bank.account.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getCustomer();
    Customer getById(Long id);
    void updateCustomerCommunication(Long id);
}
