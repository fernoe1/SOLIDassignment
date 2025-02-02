package org.example;

import org.example.database.Database;
import org.example.models.User;
import org.example.repositories.RoleRepository;
import org.example.repositories.UserRepository;
import org.example.services.UserService;

import java.util.List;
import java.util.Scanner;

public class Starter {
    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService(new UserRepository(Database.getInstance()), new RoleRepository(Database.getInstance()));
    private User user;

    public void Start() {
        int choice;

        do {
            System.out.println("Please pick an option.");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userRegister();
                    break;
                case 2:
                    user = userLogin();
                    if (user != null) {
                        System.out.println("Login successful.");
                        if (user.getRoleId() == 1) {
                            ownerMenu(user);
                        } else if (user.getRoleId() == 2) {
                            adminMenu(user);
                        } else {
                            customerMenu(user);
                        }
                    } else {
                        System.out.println("Login unsuccessful.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (choice != 3);
    }

    private void ownerMenu(User owner) {
        int choice;

        do {
            System.out.println("Role: Owner.");
            System.out.println("Welcome, " + owner.getName() + ".");
            System.out.println("Please pick an option.");
            System.out.println("[1] View all users");
            System.out.println("[2] Delete user by user ID");
            System.out.println("[3] Set role");
            System.out.println("[4] Exit");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    System.out.println("Enter user ID.");
                    int id = sc.nextInt();
                    deleteUserById(id);
                    break;
                case 3:
                    System.out.println("Enter user ID");
                    int userId = sc.nextInt();
                    System.out.println("Enter role ID");
                    int roleId = sc.nextInt();
                    setRole(userId, roleId);
                    break;
                case 4:
                    System.out.println("Exiting.");
                    break;
            }
        } while (choice != 4);
    }

    private void adminMenu(User admin) {

    }

    private void customerMenu(User customer) {

    }

    public void setRole(int user_id, int role_id) {
        userService.setRole(user_id, role_id);
    }
    public void viewAllUsers() {
        List<User> users = userService.getUsers();
        users.forEach(user -> System.out.println(user.getUser_id() + " : " + user.getName() + "\n" +
                user.getEmail() + " | " + user.getPassword() + " | " + user.getRole() + "\n"));
    }

    public void deleteUserById(int id) {
        userService.deleteUser(id);
    }

    private void userRegister() {
        System.out.println("Let us start your registration.");

        System.out.println("Please enter your name.");
        String name = sc.next();
        System.out.println("Please enter your email.");
        String email = sc.next();
        System.out.println("Please enter your password.");
        String password = sc.next();

        User user = new User(name, email, password, "Customer");

        userService.register(user);
    }

    private User userLogin() {
        System.out.println("Please enter your email.");
        String email = sc.next();

        System.out.println("Please enter your password.");
        String password = sc.next();

        return userService.getCustomerByLogin(email, password);
    }
}