package me.kevind.main;

import me.kevind.commands.ChatFilterCommand;
import me.kevind.listeners.PlayerChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatFilter extends JavaPlugin {
    private static ChatFilter instance;
    public static ChatFilter getInstance() {
        return instance;
    }
    public static String getPrefix() { return instance.getConfig().getString("Messages.Prefix");}

    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerChatEvent(), this);
        getCommand("chatfilter").setExecutor(new ChatFilterCommand());
        saveDefaultConfig();
    }
    public void onDisable() {

    }
}
