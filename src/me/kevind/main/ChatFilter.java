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
        if (Bukkit.getServer().getPluginManager().isPluginEnabled("ProtocolLib")) {
            getLogger().info("ProtocolLib found!");
        }else {
            getLogger().warning("ProtocolLib not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        if (Bukkit.getServer().getPluginManager().isPluginEnabled("PacketWrapper")) {
            getLogger().info("Found PacketWrapper, using....");
        }else {
            getLogger().warning("PacketWrapper not found, disabling...");
            if (Bukkit.getPluginManager().isPluginEnabled(this))
                Bukkit.getPluginManager().disablePlugin(this);
        }
        /*ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        manager.addPacketListener(new PacketAdapter(instance, PacketType.Play.Server.CHAT) {
            @Override
            public void onPacketSending(PacketEvent event) {
                List<String> list = instance.getConfig().getStringList("Filter");
                WrapperPlayServerChat packet = new WrapperPlayServerChat(event.getPacket());
                if (ChatColor.stripColor(packet.getMessage().getJson().equalsIgnoreCase("a"))) {

                }
            }
        });*/
        saveDefaultConfig();
    }
    public void onDisable() {

    }
}
