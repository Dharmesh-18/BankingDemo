package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

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

    public ResponseEntity<Customer> getCustomer(Long id) {
        Optional <Customer> optionalCustomer = repository.findById(id);
        if(optionalCustomer.isPresent()){
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK );
        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!!");

    }

    @Override
    public void deleteCustomer(Long id) {
        Optional <Customer> optionalCustomer = repository.findById(id);
        if(optionalCustomer.isPresent()){
            repository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not present to be deleted!!");
        }

    }


}