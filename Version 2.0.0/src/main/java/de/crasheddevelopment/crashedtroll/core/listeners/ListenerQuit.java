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

package de.crasheddevelopment.crashedtroll.core.listeners;

import de.crasheddevelopment.crashedtroll.utils.ArrayLists;
import de.crasheddevelopment.crashedtroll.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class ListenerQuit implements Listener
{
    // Quit listener.
    @EventHandler
    public void onQuit (PlayerQuitEvent playerQuitEvent)
    {
        final Player player = playerQuitEvent.getPlayer();

        if (ArrayLists.IS_VANISHED.contains(player))
        {
            ArrayLists.IS_VANISHED.remove(player);
            for (Player all : Bukkit.getOnlinePlayers())
            {
                all.showPlayer(player);
            }
        }
        else
        {
            if (ArrayLists.IS_VANISHED != null)
            {
                for (Player targetPlayer : ArrayLists.IS_VANISHED)
                {
                    if (!player.canSee(targetPlayer))
                    {
                        player.showPlayer(targetPlayer);
                    }
                }
            }
        }

        if (ArrayLists.IS_IN_TEAMCHAT.contains(player))
        {
            StringUtils.sendTeamMessage(player, "§eThe User §b" + player.getName() + " §clogged out.");
            ArrayLists.IS_IN_TEAMCHAT.remove(player);
        }

        if (ArrayLists.IS_FREEZED.contains(player))
        {
            player.setWalkSpeed(0.1F);
            ArrayLists.IS_FREEZED.remove(player);
        }
    }
}
