package org.example.repositories;

import org.example.database.Database;
import org.example.models.Customer;
import org.example.repositories.interfaces.ICustomerRepository;

import java.sql.*;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private Database database;

    public CustomerRepository(Database database) {
        this.database = database;
    }

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO Customers (name, email, password) VALUES (?, ?, ?)";

        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, customer.getCustomerName());
            st.setString(2, customer.getEmail());
            st.setString(3, customer.getPassword());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String password) {
        String sql = "SELECT name, email, password FROM Customers WHERE email = ? and password = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            String name = rs.getString("name");

            return new Customer(name, email, password);
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean login(String email, String password) {
        String sql = "SELECT 1 FROM Customers WHERE email = ? and password = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }
}
