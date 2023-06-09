package me.oyuncozucu.mcoin.utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.oyuncozucu.mcoin.MCoin;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Placeholder extends PlaceholderExpansion {

    private MCoin plugin;

    public Placeholder(MCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "mcoin";
    }

    @Override
    public @NotNull String getAuthor() {
        return "https://github.com/mertks00";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        double coin = getCoin(player);
        if (identifier.equals("coin")) {
            return String.valueOf(coin);
        }
        return null;
    }

    private double getCoin(OfflinePlayer player) {
        return plugin.getFileManager().getConfig().getDouble("player-coins." + player.getUniqueId() + ".coin");
    }
}
