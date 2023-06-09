package me.oyuncozucu.mcoin.managers;

import me.oyuncozucu.mcoin.MCoin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CoinManager {

    private MCoin plugin;

    public CoinManager(MCoin plugin) {
        this.plugin = plugin;
    }

    public void addCoin(Player player, double amount) {
        double defaultCoin = getPlugin().getFileManager().getConfig().getDouble("player-coins." + player.getUniqueId() + ".coin");
        double coin = defaultCoin + amount;
        getPlugin().getFileManager().getConfig().set("player-coins." + player.getUniqueId() + ".coin", coin);
        getPlugin().getFileManager().saveFile();
    }

    public void takeCoin(Player player, double amount) {
        double defaultCoin = getPlugin().getFileManager().getConfig().getDouble("player-coins." + player.getUniqueId() + ".coin");
        double coin = defaultCoin - amount;
        getPlugin().getFileManager().getConfig().set("player-coins." + player.getUniqueId() + ".coin", coin);
        getPlugin().getFileManager().saveFile();
    }

    public void resetCoin(Player player) {
        getPlugin().getFileManager().getConfig().set("player-coins." + player.getUniqueId() + ".coin", 0);
        getPlugin().getFileManager().saveFile();
    }

    public MCoin getPlugin() {
        return plugin;
    }

    public double getCoin(Player player) {
        return getPlugin().getFileManager().getConfig().getDouble("player-coins." + player.getUniqueId() + ".coin");
    }

}
