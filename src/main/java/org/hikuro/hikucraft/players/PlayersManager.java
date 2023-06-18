package org.hikuro.hikucraft.players;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class PlayersManager implements org.hikuro.hikucraft.Manager {

    private final Map<UUID, PlayerData> playersData = new HashMap<>();

    public void addPlayer(Player player) { playersData.put(player.getUniqueId(), new PlayerData()); }
    public void removePlayer(Player player) { playersData.remove(player.getUniqueId()); }


    // GETTERS
    public PlayerData getPlayerData(Player player) { return playersData.get(player.getUniqueId()); }
}
