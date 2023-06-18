package org.hikuro.hikucraft.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.UUID;

public class PlayerDatabase {

	private final Database db;

	public PlayerDatabase(Database db) { this.db = db; }


	public Duration getTimeSpent(UUID player) throws SQLException {
		String q = "SELECT TimePlayed FROM PlayerData WHERE UUID = ?";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setString(1, player.toString());
		return Duration.ofSeconds(s.executeQuery().getLong("TimePlayed"));
	}

	public void updateTimeSpent(UUID player, Duration timeSpent) throws SQLException {
		String q = "UPDATE PlayerData SET TimePlayed = ? WHERE UUID = ?";
		PreparedStatement s = db.getConnection().prepareStatement(q);
		s.setLong(1, timeSpent.getSeconds());
		s.setString(2, player.toString());
		s.executeUpdate();
	}

}
