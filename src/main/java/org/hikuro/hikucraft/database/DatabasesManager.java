package org.hikuro.hikucraft.database;


public class DatabasesManager implements org.hikuro.hikucraft.Manager {

    private static DatabasesManager instance = null;

    private final Database db = new Database();
    private final PlayerDatabase pDB = new PlayerDatabase(db);

    private DatabasesManager() {}

    public static DatabasesManager getInstance() {
        if (instance == null) { instance = new DatabasesManager(); }
        return instance;
    }

    public PlayerDatabase getPlayerDatabase() { return pDB; }

}
