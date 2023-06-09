package me.oyuncozucu.mcoin.listeners;

import me.oyuncozucu.mcoin.MCoin;
import me.oyuncozucu.mcoin.managers.CoinManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private MCoin plugin;
    private CoinManager coinManager;

    public JoinListener(MCoin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        boolean enable = plugin.getConfig().getBoolean("start-coins.enable");
        double coin = plugin.getConfig().getDouble("start-coins.amount");

        if(!enable) {
            System.out.print("Start Coins Disabled");
            return;
        }

        if(!player.hasPlayedBefore()) {
            coinManager = new CoinManager(plugin);
            coinManager.addCoin(player, coin);
        }

    }

}
