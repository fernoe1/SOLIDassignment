package org.example.services;

import org.example.models.Customer;
import org.example.repositories.CustomerRepository;
import org.example.services.interfaces.ICustomerService;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void register(Customer customer) {
        customerRepository.createCustomer(customer);
    }

    @Override
    public boolean login(String email, String password) {
        return customerRepository.login(email, password);
    }

    @Override
    public Customer getCustomerByLogin(String email, String password) {
        return customerRepository.getCustomerByEmailAndPassword(email, password);
    }
}
