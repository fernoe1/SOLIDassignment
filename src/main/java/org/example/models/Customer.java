package org.example.models;

public class Customer {
    private String customerName;
    private String email;
    private String password;

    public Customer() {

    }

    public Customer(String customerName, String email, String password) {
        setCustomerName(customerName);
        setEmail(email);
        setPassword(password);
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
