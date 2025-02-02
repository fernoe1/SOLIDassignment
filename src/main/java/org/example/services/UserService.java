package org.example.services;

import org.example.models.User;
import org.example.repositories.RoleRepository;
import org.example.repositories.UserRepository;
import org.example.services.interfaces.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(User user) {
        if (userRepository.createUser(user)) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("User registration failed.");
        }
    }

    @Override
    public boolean login(String email, String password) {
        if (userRepository.getUserByEmailAndPassword(email, password) != null) {

            return true;
        } else {

            return false;
        }
    }

    @Override
    public User getCustomerByLogin(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.getAllUsers();
        if (users != null) {
            System.out.println("Fetching users successful");

            return users;
        } else {
            System.out.println("Fetching users unsuccessful");

            return null;
        }
    }

    @Override
    public void deleteUser(int user_id) {
        if (userRepository.deleteUser(user_id)) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Error occurred while deleting user");
        }
    }

    @Override
    public void setRole(int user_id, int role_id) {
        if (roleRepository.setRole(user_id, role_id)) {
            System.out.println("Role set successful.");
        } else {
            System.out.println("Error occurred while setting role");
        }
    }
}
