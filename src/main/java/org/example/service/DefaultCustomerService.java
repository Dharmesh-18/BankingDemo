package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("customerService")
public class DefaultCustomerService implements CustomerService{

@Autowired
    private CustomerRepository repository ;

//    injecting the repository using the setter
    public DefaultCustomerService() {}

    public void setCustomerRepository(CustomerRepository repository){
        this.repository = repository;
    }



    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomer(Long id) {
        Optional <Customer> optionalCustomer = repository.findById(id);
        return optionalCustomer.get();

    }


}