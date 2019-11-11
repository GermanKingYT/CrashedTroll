/*
 * Copyright © 2019 CrashedDevelopment
 *
 * This is a non-commercial project.
 * All rights belong to their respective owners.
 * Our license is in the LICENSE_PROJECT.txt
 *
 * All rights and information about the used libraries is in the PUBLIC_SPIGOT_LICENSE and
 * LIBRARIES.txt and at the point "Libraries" and "Used Libraries" here.
 *
 * For news, updates and support:
 * https://discord.gg/CBkXXKa
 * https://twitter.com/crasheddevlmnt
 *
 * Development Team:
 *
 * CrashedLife | Sören (Developed everything.):
 * Discord: CrashedLife#9417
 * Twitter: https://twitter.com/sqliCrashedLife
 * Github: https://github.com/CrashedLife
 * YouTube: https://www.youtube.com/channel/UC3alimqGC2YcgEK7jc_N4mg
 *
 * Luca (Staff):
 * Discord: Luca.#1337
 * Twitter: https://twitter.com/luca1337_
 *
 * Libraries:
 * We used libraries to complete our project and respect and thanks every single owner that created the library.
 * If some owner has problems with it please contact us.
 *
 * Used Libraries:
 * Spigot © Spigot
 * Spigot: https://www.spigotmc.org/wiki/about-spigot/
 * License: Public License (PUBLIC_SPIGOT_LICENSE.txt)
 */

package de.crasheddevelopment.crashedtroll.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class StringUtils
{
    // Plugin version string.
    public static final String VERSION = "2.0.0";

    // Plugin build string.
    public static final String BUILD = "7";

    // Plugin prefix string.
    private static final String PREFIX = "§7[§5§lCrashedTroll§7]: ";

    // Plugin team chat prefix stream.
    private static final String TEAM_CHAT_PREFIX = "§7[§5§lCrashedTroll-TeamChat§7]: §6";

    // Plugin no permissions string.
    public static final String NO_PERMISSIONS = PREFIX + "§cYou do not have permissions to execute this command!";

    // Plugin player is offline string.
    public static final String PLAYER_OFFLINE = PREFIX + "§cThis player is not online!";

    // Send output.
    public static void sendInformation (String message)
    {
        System.out.println("[CrashedTroll]: " + message);
    }

    // Sends an player message.
    public static void sendPlayerMessage (Player player, String message)
    {
        player.sendMessage(PREFIX + message);
    }

    // Sends an team chat message.
    public static void sendTeamMessage (Player player, String message)
    {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers())
        {
            if (ArrayLists.IS_IN_TEAMCHAT.contains(onlinePlayers))
            {
                onlinePlayers.sendMessage(TEAM_CHAT_PREFIX + "§7<§e" + player.getName() + "§7>: §a" + message);
            }
        }
    }

    // Sends an team chat broadcast.
    public static void sendTeamBroadcast (String message)
    {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers())
        {
            if (ArrayLists.IS_IN_TEAMCHAT.contains(onlinePlayers))
            {
                onlinePlayers.sendMessage(TEAM_CHAT_PREFIX + message);
            }
        }
    }
}