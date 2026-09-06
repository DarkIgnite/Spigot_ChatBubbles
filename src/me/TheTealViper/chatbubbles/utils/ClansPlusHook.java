package me.TheTealViper.chatbubbles.utils;

import java.lang.reflect.Method;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClansPlusHook {

    /**
     * Checks whether the player is currently typing in ClansPlus clan chat mode (/clan chat)
     * or participating in an interactive prompt (such as clan creation, custom name, etc.).
     *
     * @param player The player to check
     * @return true if clan chat or prompt is active, false otherwise
     */
    public static boolean isClanChatActive(Player player) {
        if (!Bukkit.getPluginManager().isPluginEnabled("ClansPlus")) {
            return false;
        }

        try {
            // 1. Check if player has clan chat toggled on (/clan chat)
            List<Player> clanChatPlayers = com.cortezromeo.clansplus.clan.ClanManager.getPlayerUsingClanChat();
            if (clanChatPlayers != null && clanChatPlayers.contains(player)) {
                return true;
            }

            // 2. Check if player is responding to interactive chat prompts (creating clan, setting custom name, setting message)
            if (com.cortezromeo.clansplus.listener.ChatListenerHandler.createClan.contains(player)
                    || com.cortezromeo.clansplus.listener.ChatListenerHandler.setCustomName.contains(player)
                    || com.cortezromeo.clansplus.listener.ChatListenerHandler.setMessage.contains(player)) {
                return true;
            }
        } catch (Throwable t) {
            // Safe reflection fallback in case of classloader / jar structure variations
            try {
                Class<?> clanManagerClass = Class.forName("com.cortezromeo.clansplus.clan.ClanManager");
                Method getPlayerUsingClanChatMethod = clanManagerClass.getMethod("getPlayerUsingClanChat");
                List<?> list = (List<?>) getPlayerUsingClanChatMethod.invoke(null);
                if (list != null && list.contains(player)) {
                    return true;
                }
            } catch (Throwable ignored) {
            }
        }

        return false;
    }
}
