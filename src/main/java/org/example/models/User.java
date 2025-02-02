package org.example.models;

import java.util.Objects;

public class User {
    private int user_id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User() {

    }

    public User(String name, String email, String password, String role) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public User(int user_id, String name, String email, String password, String role) {
        setUser_id(user_id);
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public int getRoleId() {
        if (Objects.equals(role, "Owner")) {

            return 1;

        } else if (Objects.equals(role, "Admin")) {

            return 2;
        } else {

            return 3;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
