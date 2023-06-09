package me.oyuncozucu.mcoin;

import me.oyuncozucu.mcoin.commands.CoinCommand;
import me.oyuncozucu.mcoin.commands.tabCompleter.CoinCommandComplete;
import me.oyuncozucu.mcoin.listeners.JoinListener;
import me.oyuncozucu.mcoin.managers.FileManager;
import me.oyuncozucu.mcoin.utils.GivenType;
import me.oyuncozucu.mcoin.utils.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCoin extends JavaPlugin {

    private FileManager fileManager;

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        fileManager = new FileManager(this);
        fileManager.createFile();

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new Placeholder(this).register();
        }

        Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);

        getCommand("mcoin").setExecutor(new CoinCommand(this));
        getCommand("mcoin").setTabCompleter(new CoinCommandComplete());

    }

    public FileManager getFileManager() {
        return fileManager;
    }

}
