package me.oyuncozucu.mcoin.commands;

import me.oyuncozucu.mcoin.MCoin;
import me.oyuncozucu.mcoin.managers.CoinManager;
import me.oyuncozucu.mcoin.managers.LogManager;
import me.oyuncozucu.mcoin.utils.GivenType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CoinCommand implements CommandExecutor {

    private MCoin plugin;
    private CoinManager coinManager;
    private LogManager logManager;

    public CoinCommand(MCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        coinManager = new CoinManager(JavaPlugin.getPlugin(MCoin.class));

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 3) {
                if(!player.hasPermission("mcoin.admin")) {
                    player.sendMessage(ChatColor.RED + "Buna izniniz yok!");
                    return false;
                }
                switch (args[0].toLowerCase()) {
                    case "add":
                        coinManager.addCoin(Bukkit.getPlayer(args[1]), Double.parseDouble(args[2]));
                        if(!plugin.getConfig().getBoolean("logs.enable")) {
                            return false;
                        }
                        logManager = new LogManager(plugin);
                        logManager.logIn(player, Bukkit.getPlayer(args[1]), Double.parseDouble(args[2]), GivenType.ADD);
                        break;
                    case "take":
                        coinManager.takeCoin(Bukkit.getPlayer(args[1]), Double.parseDouble(args[2]));
                        if(!plugin.getConfig().getBoolean("logs.enable")) {
                            return false;
                        }
                        logManager = new LogManager(plugin);
                        logManager.logIn(player, Bukkit.getPlayer(args[1]), Double.parseDouble(args[2]), GivenType.TAKE);
                        break;
                }
            } else if (args.length == 2) {
                if(!player.hasPermission("mcoin.admin")) {
                    player.sendMessage(ChatColor.RED + "Buna izniniz yok!");
                    return false;
                }
                if(args[0].equalsIgnoreCase("reset")) {
                    coinManager.resetCoin(Bukkit.getPlayer(args[1]));
                    if(!plugin.getConfig().getBoolean("logs.enable")) {
                        return false;
                    }
                    logManager = new LogManager(plugin);
                    logManager.logIn(player,Bukkit.getPlayer(args[1]), GivenType.RESET);
                }
            } else if (args.length == 1) {
                if(args[0].equalsIgnoreCase("coin")) {
                    double coin = coinManager.getCoin(player);
                    player.sendMessage(ChatColor.GREEN + "Coin: " + ChatColor.YELLOW + coin);
                }
            }

        }

        return true;
    }

}
