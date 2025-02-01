package org.example;

import org.example.database.Database;
import org.example.repositories.CustomerRepository;
import org.example.repositories.ProductRepository;
import org.example.services.CustomerService;
import org.example.services.OrderService;
import org.example.services.ProductService;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Starter starter = new Starter();
        starter.Start();
    }
}