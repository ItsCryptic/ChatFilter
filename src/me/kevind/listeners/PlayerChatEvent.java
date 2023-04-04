package me.kevind.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.kevind.main.ChatFilter;
import me.kevind.utils.ColorUtils;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.List;

public class PlayerChatEvent implements Listener {
    private LegacyComponentSerializer legacy = LegacyComponentSerializer.legacySection();
    @EventHandler (priority = EventPriority.HIGHEST)
    public void PlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        List<String> list = ChatFilter.getInstance().getConfig().getStringList("Filter");
        String message = legacy.serialize(event.message());
        for (String string : message.split(" ")) {
            if (list.contains(string.toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(ColorUtils.color(ChatFilter.getPrefix() + "&7Hey &9" + player.getName() + "&7, you can't say that &7here."));
                return;
            }

        }
    }
}
