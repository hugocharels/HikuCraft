package org.hikuro.hikucraft.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.hikuro.hikucraft.player.PlayersManager;

public class PlayersListener implements Listener {

	private final PlayersManager pManager = PlayersManager.getInstance();


	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) { pManager.joinPlayer(event.getPlayer()); }

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) { pManager.quitPlayer(event.getPlayer()); }

}
