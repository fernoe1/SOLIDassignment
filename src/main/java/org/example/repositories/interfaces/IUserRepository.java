package org.example.repositories.interfaces;

import org.example.models.User;

import java.util.List;

public interface IUserRepository {
    boolean createUser(User user);

    User getUserByEmailAndPassword(String email, String password);

    List<User> getAllUsers();

    int getUserId(String email);

    boolean deleteUser(int user_id);
}
