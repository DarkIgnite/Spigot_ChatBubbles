package me.TheTealViper.chatbubbles.utils;

import java.lang.reflect.Method;
import org.bukkit.entity.Player;

public class FactionsHook {

    public static String getFactionName(Player player) {
        if (player == null) return "";
        try {
            Class<?> mplayerClass = Class.forName("com.massivecraft.factions.entity.MPlayer");
            Method getMethod = mplayerClass.getMethod("get", Object.class);
            Object mplayer = getMethod.invoke(null, player);
            if (mplayer != null) {
                Method getFactionNameMethod = mplayer.getClass().getMethod("getFactionName");
                Object name = getFactionNameMethod.invoke(mplayer);
                return name != null ? name.toString() : "";
            }
        } catch (Throwable ignored) {
        }
        return "";
    }
}
