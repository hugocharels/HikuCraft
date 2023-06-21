package org.hikuro.hikucraft.player;

import java.time.Duration;
import java.time.LocalTime;


public class PlayerData {

    private final LocalTime connectionTime;

    public PlayerData() {
        this.connectionTime = LocalTime.now();
    }

    public Duration getTimeSpent() { return Duration.between(LocalTime.now(), connectionTime); }


}
