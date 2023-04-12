package me.kevind.commands;

import me.kevind.main.ChatFilter;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class ChatFilterCommand implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            List<String> list = ChatFilter.getInstance().getConfig().getStringList("Filter");
            if (player.hasPermission("vibe.chatfilter")) {
                if (args.length == 0) {
                    player.sendMessage(ColorUtils.color(ChatFilter.getPrefix() + "&7Filter\n&7/chatfilter add <word> - Adds a word to the filter\n&7/chatfilter remove <word> - Removes a word from the filter.\n&7/chatfilter reload - Reloads the plugin"));
                } else {
                    if (args[0].equalsIgnoreCase("reload")) {
                        ChatFilter.getInstance().reloadConfig();
                        player.sendMessage(ColorUtils.color(ChatFilter.getPrefix() + "&aReloaded config."));
                    }
                    if (args[0].equalsIgnoreCase("add")) {
                        list.add(args[1]);
                        ChatFilter.getInstance().getConfig().set("Filter", list);
                        player.sendMessage(ColorUtils.color("&7Added &9" + args[1] + " &7to filter."));
                        ChatFilter.getInstance().saveConfig();
                    }
                    if (args[0].equalsIgnoreCase("remove")) {
                        list.remove(args[1]);
                        ChatFilter.getInstance().getConfig().set("Filter", list);
                        player.sendMessage(ColorUtils.color("&7Removed &9" + args[1] + " &7from filter."));
                        ChatFilter.getInstance().saveConfig();
                    }
                }
                } else {
                player.sendMessage(ColorUtils.color("&cYou do not have permission to run this command."));
            }
            } else {
                sender.sendMessage("You need to be a player to use this command.");
            }
        return false;
    }
}
