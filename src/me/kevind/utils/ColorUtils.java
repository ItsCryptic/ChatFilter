package me.kevind.utils;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class ColorUtils {
    public static @NotNull String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
