package org.example.repository;

import org.example.model.Customer;

import java.util.List;

public interface CustomerRepository {

    public List<Customer> findAll();

}