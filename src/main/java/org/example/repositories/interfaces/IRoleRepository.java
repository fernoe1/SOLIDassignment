package org.example.repositories.interfaces;

public interface IRoleRepository {
    String getRole(int roleId);

    boolean setRole(int userId, int roleId);
}
