package org.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Money {

    private Main plugin;
    FileConfiguration config;

    public Money(Main plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
    }

    public void makePlayerDataOnJoin(Player p) {
        //config.addDefault("money", 0);
        plugin.saveConfig();

        if (!config.contains(p.getName())) {
            config.set(p.getName()+".money", 0);
        }
    }

    public void showPlayerDataOnCommand(Player p, Command command, String[] args) {
        if (command.getName().equalsIgnoreCase("돈")) {
            p.sendMessage("돈 :"+config.get(p.getName()+".money"));
        }
    }










}
