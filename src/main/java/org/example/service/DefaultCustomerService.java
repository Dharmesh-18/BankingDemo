package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("customerService")
public class DefaultCustomerService implements CustomerService{


    private CustomerRepository repository ;

//    injecting the repository using the setter
    public DefaultCustomerService() {}

    public void setCustomerRepository(CustomerRepository repository){
        this.repository = repository;
    }



    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public List<Customer> getAllCustomersWithStars() {
        return repository.findAll()
                .stream()
                .map(c -> new Customer(c.getId(), c.getName(), c.getCity()))
                .collect(Collectors.toList());

    }

    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }
}