package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private List<Product> productList = new ArrayList<>();

    public Order() {

    }

    public Order(User user) {
        setCustomer(user);
    }

    public void setCustomer(User user) {
        this.user = user;
    }

    public User getCustomer() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
