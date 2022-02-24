package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomer(Long id);

}