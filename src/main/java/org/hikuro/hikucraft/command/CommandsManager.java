package org.hikuro.hikucraft.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hikuro.hikucraft.HikuCraft;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class CommandsManager implements org.hikuro.hikucraft.Manager, org.bukkit.command.CommandExecutor {

	private static CommandsManager instance = null;

	private CommandsManager() {}

	public static CommandsManager getInstance() {
		if (instance == null) { instance = new CommandsManager(); }
		return instance;
	}

	private boolean isPlayer(CommandSender sender) {
		return sender instanceof Player;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
		if (!isPlayer(sender)) { return true; }
		Player player = (Player) sender;
		CommandExecutor executor;
		switch (cmd.getName().toLowerCase()) {
			case "sethome" :
			case "delhome" :
			case "home"    : executor = new HomeCommandExecutor(); break;
			case "tpaccept":
			case "tp"      : executor = new TeleportCommandExecutor(); break;
			default        : executor = new DefaultCommandExecutor();
		}
		return executor.execute(player, args);
	}

	public void registerCommands(HikuCraft hikuCraft) {
		for (String command : new String[] {"home", "sethome", "delhome", "tp", "tpaccept"}) {
			Objects.requireNonNull(hikuCraft.getCommand(command)).setExecutor(this);
		}
	}

}
