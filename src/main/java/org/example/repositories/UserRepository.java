package org.example.repositories;

import org.example.database.Database;
import org.example.models.User;
import org.example.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static UserRepository instance;
    private Database database;

    public UserRepository(Database database) {
        this.database = database;
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository(Database.getInstance());
                }
            }
        }

        return instance;
    }

    @Override
    public boolean createUser(User user) {
        String sql = "INSERT INTO users (name, email, password, role_id) VALUES (?, ?, ?, ?)";

        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.setInt(4, user.getRoleId());

            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());

            return false;
        }
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT user_id, name, email, password, role_id FROM users WHERE email = ? and password = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                String roleName = RoleRepository.getInstance().getRole(rs.getInt("role_id"));

                return new User(user_id, name, email, password, roleName);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, name, email, password, role_id FROM users";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = RoleRepository.getInstance().getRole(rs.getInt("role_id"));
                users.add(new User(user_id, name, email, password, role));
            }

            return users;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public int getUserId(String email) {
        String sql = "SELECT user_id FROM users WHERE email = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return 0;
    }

    @Override
    public boolean deleteUser(int user_id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, user_id);
            st.executeUpdate();

            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());

            return false;
        }
    }
}
