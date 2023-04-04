package me.kevind.utils;

import me.kevind.main.ChatFilter;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class FileConfiguration {
    private Player player;
    private File dataFile;
    private org.bukkit.configuration.file.FileConfiguration  data;
    private File playerfile;
    private org.bukkit.configuration.file.FileConfiguration players;




    public void createFiles() throws IOException {
        if (!ChatFilter.getInstance().getDataFolder().exists()) ChatFilter.getInstance().getDataFolder().mkdir();
        playerfile = new File(ChatFilter.getInstance().getDataFolder() + "logs/players/", player.getUniqueId().toString() + ".yml");
        dataFile = new File(ChatFilter.getInstance().getDataFolder() + "");
    }

}
