package org.hikuro.hikucraft.database;

// lib imports
import java.sql.*;

import static java.lang.Thread.sleep;

public class Database {

	private final Connection connection;

	public Database() {
		String url = "jdbc:mysql://localhost:3306/HikuCraft";
		String username = "HikuCraft_user";
		String password = "HikuCraft_user_psw";
		connection = connect(url, username, password);
	}

	public Connection connect(String url, String username, String password) {
		while (true) {
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("Error connecting to database");
				System.out.println("Retrying in 5 seconds...");
				try { sleep(5000); } catch (InterruptedException ignored) {}
			}
		}
	}

	public void disconnect() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	public Connection getConnection() throws SQLException {
		return connection;
	}


}

