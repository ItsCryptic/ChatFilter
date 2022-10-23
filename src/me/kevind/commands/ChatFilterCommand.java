package me.kevind.commands;

import me.kevind.main.ChatFilter;
import me.kevind.utils.ColorUtils;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatFilterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("vibe.chatfilter")) {
                if (args[0] == null) {
                    player.sendMessage(ColorUtils.color(ChatFilter.getPrefix() + "&cPlease specify either add or list!"));
                }if (args[0].equalsIgnoreCase("reload")) {
                    ChatFilter.getInstance().reloadConfig();
                    player.sendMessage(ColorUtils.color(ChatFilter.getPrefix() + "&aReloaded config."));
                }
            } else {
                player.sendMessage(ColorUtils.color(ChatFilter.getPrefix() + "&cYou do not have permission to execute this command!"));
            }
        }else {
            sender.sendMessage("You need to be a player to use this command.");
        }
        return false;
    }
}
