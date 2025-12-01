package org.plugin.util;

import org.bukkit.Bukkit;
import org.plugin.Main;

public class Scheduler {
    private final Main plugin = Main.getInstance();

    public void task(Runnable action, long delay, long period) {
        Bukkit.getScheduler().runTaskTimer(plugin, action, delay, period);
    }
}
