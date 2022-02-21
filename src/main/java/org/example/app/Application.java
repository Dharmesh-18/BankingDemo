package org.example.app;

import org.example.model.Customer;
import org.example.service.DefaultCustomerService;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        DefaultCustomerService service = new DefaultCustomerService();

        List<Customer> customers = service.getAllCustomersWithStars();

        customers.forEach(System.out::println);

    }
}

