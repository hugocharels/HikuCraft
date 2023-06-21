package org.hikuro.hikucraft;

import org.bukkit.plugin.java.JavaPlugin;

import org.hikuro.hikucraft.command.CommandsManager;
import org.hikuro.hikucraft.database.DatabasesManager;
import org.hikuro.hikucraft.listener.ListenersManager;
import org.hikuro.hikucraft.player.PlayersManager;


public final class HikuCraft extends JavaPlugin {

	private final CommandsManager cManager = CommandsManager.getInstance();
	private final DatabasesManager dbManager = DatabasesManager.getInstance();
	private final PlayersManager pManager = PlayersManager.getInstance();
	private final ListenersManager lManager = ListenersManager.getInstance();


	@Override
	public void onEnable() {
		// Plugin startup logic
		cManager.registerCommands(this);
		lManager.registerListeners(this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}


}
