package me.oyuncozucu.mcoin.commands.tabCompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CoinCommandComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {

        List<String> results = new ArrayList<>();

        if(args.length == 1) {
            results.add("add");
            results.add("coin");
            results.add("reset");
            results.add("take");
        } else if (args.length == 2) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                results.add(player.getName());
            }
        } else if (args.length == 3 || args[1].equalsIgnoreCase("add") || args[1].equalsIgnoreCase("take")) {
            results.add("10000");
            results.add("1000");
            results.add("100");
            results.add("10");
            results.add("1");
        }

        return results;
    }

}
