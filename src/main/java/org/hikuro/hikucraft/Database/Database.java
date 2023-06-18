package org.hikuro.hikucraft.Database;

// lib imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private final Connection connection;

    public Database() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/HikuCraft";
        String username = "HikuCraft_user";
        String password = "HikuCraft_user_psw";
        connection = connect(url, username, password);
    }

    public Connection connect(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

}

