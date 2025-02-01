package org.example.database.interfaces;

import java.sql.Connection;

public interface IDatabase {
    Connection getConnection();

    void close();
}
