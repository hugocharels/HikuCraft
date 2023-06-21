package org.hikuro.hikucraft.command;

import org.bukkit.entity.Player;


public interface CommandExecutor {

	public boolean execute(Player player, String[] args);

}
