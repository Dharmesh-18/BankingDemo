package org.example.app;

import org.example.model.Customer;
import org.example.repository.CustomerRepositoryDB;
import org.example.repository.CustomerRepositoryStub;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;

import java.util.List;

//IoC Container
public class Application {

    public static void main(String[] args) {

// wiring your application
        CustomerService service = new DefaultCustomerService(newCustomerRepositoryDB());

        List<Customer> customers = service.getAllCustomersWithStars();

        customers.forEach(System.out::println);

    }

    public static CustomerRepositoryDB newCustomerRepositoryDB() {
        return new CustomerRepositoryDB();
    }

    public static CustomerRepositoryStub newCustomerRepositoryStub() {
        return new CustomerRepositoryStub();
    }
}

