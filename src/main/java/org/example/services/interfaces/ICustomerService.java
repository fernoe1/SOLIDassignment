package org.example.services.interfaces;

import org.example.models.Customer;

public interface ICustomerService {
    void register(Customer customer);

    boolean login(String email, String password);

    Customer getCustomerByLogin(String email, String password);
}
