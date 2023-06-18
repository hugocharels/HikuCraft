package org.hikuro.hikucraft.players;

import java.time.Duration;
import java.time.LocalTime;


public class PlayerData {

    private final LocalTime connectionTime;

    public PlayerData() {
        this.connectionTime = LocalTime.now();
    }

    public Duration getTimeSpent() { return Duration.between(LocalTime.now(), connectionTime); }


}
