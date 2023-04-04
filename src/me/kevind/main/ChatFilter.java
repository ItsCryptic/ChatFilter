package me.kevind.main;

import com.comphenix.packetwrapper.WrapperPlayServerChat;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.kevind.commands.ChatFilterCommand;
import me.kevind.listeners.PlayerChatEvent;
import net.kyori.adventure.text.serializer.ComponentSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ChatFilter extends JavaPlugin {
    private static ChatFilter instance;
    public static ChatFilter getInstance() {
        return instance;
    }
    public static String getPrefix() { return instance.getConfig().getString("Messages.Prefix");}

    public void onEnable() {
        instance = this;
        getCommand("chatfilter").setExecutor(new ChatFilterCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerChatEvent(), this);
        saveDefaultConfig();
    }
    public void onDisable() {

    }
}
