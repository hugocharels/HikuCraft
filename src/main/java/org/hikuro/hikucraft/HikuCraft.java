package org.hikuro.hikucraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import org.hikuro.hikucraft.commands.CommandsManager;
import org.hikuro.hikucraft.database.DatabaseManager;
import org.hikuro.hikucraft.players.PlayersManager;


public final class HikuCraft extends JavaPlugin {

	private final CommandsManager commandsManager = CommandsManager.getInstance();
	private final DatabaseManager databaseManager = DatabaseManager.getInstance();
	private final PlayersManager playersManager = PlayersManager.getInstance();


	@Override
	public void onEnable() {
		// Plugin startup logic
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) { playersManager.joinPlayer(event.getPlayer()); }

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) { playersManager.quitPlayer(event.getPlayer()); }

}
