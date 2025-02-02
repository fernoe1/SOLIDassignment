package org.example.services.interfaces;

import org.example.models.User;

import java.util.List;

public interface IUserService {
    void register(User user);

    boolean login(String email, String password);

    User getCustomerByLogin(String email, String password);

    List<User> getUsers();

    void deleteUser(int user_id);

    void setRole(int user_id, int role_id);
}
