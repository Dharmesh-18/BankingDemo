package org.example.repository;

import org.example.model.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository("db")
@Primary
public class CustomerRepositoryDB implements CustomerRepository{

    public List<Customer> findAll(){

        List<Customer> customers = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/banking?user=root&password=student");
            PreparedStatement ps = connection.prepareStatement("Select customer_id, name, city from customers");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Customer customer = new Customer(
                        rs.getString("customer_id"),
                        rs.getString("name"),
                        rs.getString("city")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
