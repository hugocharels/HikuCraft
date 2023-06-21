package org.hikuro.hikucraft.player;

import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class PlayersData {

	private final Map<UUID, PlayerData> playersData = new HashMap<>();

	public void addPlayer(Player player) { playersData.put(player.getUniqueId(), new PlayerData()); }
	public void removePlayer(Player player) { playersData.remove(player.getUniqueId()); }

	// GETTERS
	public PlayerData getPlayerData(Player player) { return playersData.get(player.getUniqueId()); }

	public Duration getPlayerTimeSpent(Player player) { return playersData.get(player.getUniqueId()).getTimeSpent(); }

}
