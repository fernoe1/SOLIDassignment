package org.example.repositories;

import org.example.database.Database;
import org.example.repositories.interfaces.IRoleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRepository implements IRoleRepository {
    private static RoleRepository instance;
    private Database database;

    public RoleRepository(Database database) {
        this.database = database;
    }

    public static RoleRepository getInstance() {
        if (instance == null) {
            synchronized (RoleRepository.class) {
                if (instance == null) {
                    instance = new RoleRepository(Database.getInstance());
                }
            }
        }

        return instance;
    }

    @Override
    public String getRole(int role_id) {
        String sql = "SELECT role_name FROM roles WHERE role_id = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, role_id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getString("role_name");
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        return "";
    }

    @Override
    public boolean setRole(int user_id, int role_id) {
        String sql = "UPDATE users SET role_id = ? WHERE user_id = ?";
        try {
            Connection con = database.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, role_id);
            st.setInt(2, user_id);

            st.executeUpdate();

            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());

            return false;
        }
    }
}
