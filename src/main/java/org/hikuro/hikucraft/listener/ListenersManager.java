package org.hikuro.hikucraft.listener;


import org.hikuro.hikucraft.HikuCraft;

public class ListenersManager {

	private static ListenersManager instance = null;

	private final PlayersListener pListener = new PlayersListener();


	private ListenersManager() {}

	public static ListenersManager getInstance() {
		if (instance == null) { instance = new ListenersManager(); }
		return instance;
	}


	public void registerListeners(HikuCraft hikuCraft) {
		hikuCraft.getServer().getPluginManager().registerEvents(pListener, hikuCraft);
	}

}
