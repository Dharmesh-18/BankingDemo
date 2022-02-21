package org.example.app;

import org.example.model.Customer;
import org.example.repository.CustomerRepositoryDB;
import org.example.repository.CustomerRepositoryStub;
import org.example.service.DefaultCustomerService;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        CustomerRepositoryStub stubRepository = new CustomerRepositoryStub();
        CustomerRepositoryDB dbRepository = new CustomerRepositoryDB();

        DefaultCustomerService service = new DefaultCustomerService(stubRepository);

        List<Customer> customers = service.getAllCustomersWithStars();

        customers.forEach(System.out::println);

    }
}

