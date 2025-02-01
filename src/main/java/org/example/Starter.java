package org.example;

import org.example.models.*;

import org.example.services.CustomerService;
import org.example.services.OrderService;
import org.example.services.ProductService;

import java.util.Scanner;

public class Starter {
    private CustomerService customerService;
    private ProductService productService;
    private OrderService orderService;

    public Starter(CustomerService customerService, ProductService productService, OrderService orderService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }
    public void Start() {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        do {
            System.out.println("Please login or register.");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            switch(choice){
                case 1:
                    System.out.println("Enter your email and password.");
                    sc.next();
                    String email = sc.next();
                    String password = sc.next();
                    if (customerService.login(email, password)) {
                        System.out.println("Login successfull!");
                        menu(customerService.getCustomerByLogin(email, password));
                    } else {
                        System.out.println("Login unseccussfull, please try again");
                        break;
                    }
            }

        }while(choice != 3);
    }

    private void menu(Customer customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customer.getCustomerName() + "!");
        System.out.println("Menu");
        System.out.println("[1] View all products");
        System.out.println("[2] Make order");
        System.out.println("[3] View order");
        System.out.println("[4] Finish order");
    }
}