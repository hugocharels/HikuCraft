package org.hikuro.hikucraft.commands;


public class CommandsManager implements org.hikuro.hikucraft.Manager {

    private static CommandsManager instance = null;

    private CommandsManager() {}

    public static CommandsManager getInstance() {
        if (instance == null) { instance = new CommandsManager(); }
        return instance;
    }


}
