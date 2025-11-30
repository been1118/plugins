package org.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.plugin.Money.getMoney;
import static org.plugin.Money.showPlayerDataOnCommand;

public class UseCommand implements CommandExecutor {
    private Main plugin;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("돈")) {
             new MoneyCommand(sender, command,args);
        }
        return true;



    }




}
