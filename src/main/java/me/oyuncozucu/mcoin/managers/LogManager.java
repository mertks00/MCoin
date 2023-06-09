package me.oyuncozucu.mcoin.managers;

import me.oyuncozucu.mcoin.MCoin;
import me.oyuncozucu.mcoin.utils.GivenType;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager {

    private static MCoin plugin;

    public LogManager(MCoin plugin) {
        LogManager.plugin = plugin;
    }

    public void logIn(Player player, Player target, double amount, GivenType type) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date()).replace(":", "");
        String invalidCharacters = "[\\\\/:*?\"<>|]";
        String logFileName = dateTime + ".[" + player.getName() + "]" + ".txt";
        String sanitizedLogFileName = logFileName.replaceAll(invalidCharacters, "");
        String logFolderPath = plugin.getFileManager().getLogsFolder().getPath();
        String logFilePath = logFolderPath + File.separator + sanitizedLogFileName;


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath));
            writer.write("Tarih: " + dateTime);
            writer.newLine();
            writer.write("İşlemi Yapan: " + player.getName());
            writer.newLine();
            writer.write("İşlem Yapılan: " + target.getName());
            writer.newLine();
            writer.write("İşlem: " + type);
            writer.newLine();
            writer.write("Miktar: " + amount);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void logIn(Player player, Player target, GivenType type) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date()).replace(":", "");
        String invalidCharacters = "[\\\\/:*?\"<>|]";
        String logFileName = dateTime + ".[" + player.getName() + "]" + ".txt";
        String sanitizedLogFileName = logFileName.replaceAll(invalidCharacters, "");
        String logFolderPath = plugin.getFileManager().getLogsFolder().getPath();
        String logFilePath = logFolderPath + File.separator + sanitizedLogFileName;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath));
            writer.write("Tarih: " + dateTime);
            writer.newLine();
            writer.write("İşlemi Yapan: " + player.getName());
            writer.newLine();
            writer.write("İşlem Yapılan: " + target.getName());
            writer.newLine();
            writer.write("İşlem: " + type);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
