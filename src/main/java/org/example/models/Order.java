package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> productList = new ArrayList<>();

    public Order() {

    }

    public Order(Customer customer) {
        setCustomer(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
