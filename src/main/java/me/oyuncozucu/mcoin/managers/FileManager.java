package me.oyuncozucu.mcoin.managers;

import me.oyuncozucu.mcoin.MCoin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private MCoin plugin;
    private File file;
    private YamlConfiguration config;
    public File logsFolder;

    public FileManager(MCoin plugin) {
        this.plugin = plugin;
    }

    public void saveFile() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile() {

        File dataFolder = new File(plugin.getDataFolder(), "data");
        logsFolder = new File(plugin.getDataFolder(), "logs");

        if(!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        if(!logsFolder.exists()) {
            logsFolder.mkdirs();
        }

        file = new File(dataFolder, "data.yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public File getFile() {
        return file;
    }

    public File getLogsFolder() {
        return logsFolder;
    }

}
