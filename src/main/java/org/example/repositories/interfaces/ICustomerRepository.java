package org.example.repositories.interfaces;

import org.example.models.Customer;

import java.util.List;

public interface ICustomerRepository {
    void createCustomer(Customer customer);

    Customer getCustomerByEmailAndPassword(String email, String password);

    boolean login(String email, String password);

    List<Customer> getAll();
}
