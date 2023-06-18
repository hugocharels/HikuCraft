package org.hikuro.hikucraft.players;


import org.bukkit.entity.Player;
import org.hikuro.hikucraft.database.DatabaseManager;
import org.hikuro.hikucraft.database.PlayerDatabase;

import java.time.Duration;

public class PlayersManager implements org.hikuro.hikucraft.Manager {

	private static PlayersManager instance = null;

	private final PlayersData playersData = new PlayersData();

	private PlayersManager() {}

	public static PlayersManager getInstance() {
		if (instance == null) { instance = new PlayersManager(); }
		return instance;
	}


	public void joinPlayer(Player player) {
		playersData.addPlayer(player);
		// TODO: Load player data from database
	}

	public void quitPlayer(Player player) {
		playersData.removePlayer(player);
		try {
			PlayerDatabase db = DatabaseManager.getInstance().getPlayerDatabase();
			Duration timeSpent = playersData.getPlayerTimeSpent(player);
			Duration timeSpentInDatabase = db.getTimeSpent(player.getUniqueId());
			db.updateTimeSpent(player.getUniqueId(), timeSpent.plus(timeSpentInDatabase));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
