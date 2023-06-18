package org.hikuro.hikucraft.database;


import org.hikuro.hikucraft.commands.CommandsManager;

public class DatabaseManager implements org.hikuro.hikucraft.Manager {

    private static DatabaseManager instance = null;

    private final Database db = new Database();
    private final PlayerDatabase pDB = new PlayerDatabase(db);

    private DatabaseManager() {}

    public static DatabaseManager getInstance() {
        if (instance == null) { instance = new DatabaseManager(); }
        return instance;
    }

    public PlayerDatabase getPlayerDatabase() { return pDB; }

}
