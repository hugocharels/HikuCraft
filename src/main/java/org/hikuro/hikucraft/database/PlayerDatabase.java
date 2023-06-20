package org.hikuro.hikucraft.database;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.UUID;

public class PlayerDatabase {

	private final Database db;

	public PlayerDatabase(Database db) { this.db = db; }


	public void createPlayer(UUID player) throws SQLException {
		String q = "INSERT INTO PlayerDatas (UUID) VALUES (?)";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setString(1, player.toString());
		s.executeUpdate();
	}

	public Duration getTimeSpent(UUID player) throws SQLException {
		String q = "SELECT TimeSpent FROM PlayerDatas WHERE UUID = ?";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setString(1, player.toString());
		return Duration.ofSeconds(s.executeQuery().getLong("TimePlayed"));
	}

	public void updateTimeSpent(UUID player, Duration timeSpent) throws SQLException {
		String q = "UPDATE PlayerDatas SET TimeSpent = ? WHERE UUID = ?";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setLong(1, timeSpent.getSeconds());
		s.setString(2, player.toString());
		s.executeUpdate();
	}

	public void createHome(UUID player, String homeName, Location location) throws SQLException {
		String q = "INSERT INTO Homes (UUID, Name, World, X, Y, Z) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setString(1, player.toString());
		s.setString(2, homeName);
		s.setString(3, location.getWorld().getName());
		s.setDouble(4, location.getX());
		s.setDouble(5, location.getY());
		s.setDouble(6, location.getZ());
		s.executeUpdate();
	}

	public Location getHome(UUID player, String homeName) throws SQLException {
		String q = "SELECT World, X, Y, Z FROM Homes WHERE UUID = ? AND Name = ?";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setString(1, player.toString());
		s.setString(2, homeName);
		return new Location(
				Bukkit.getWorld(s.executeQuery().getString("World")),
				s.executeQuery().getDouble("X"),
				s.executeQuery().getDouble("Y"),
				s.executeQuery().getDouble("Z")
		);
	}

	public void deleteHome(UUID player, String homeName) throws SQLException {
		String q = "DELETE FROM Homes WHERE UUID = ? AND Name = ?";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setString(1, player.toString());
		s.setString(2, homeName);
		s.executeUpdate();
	}



}
