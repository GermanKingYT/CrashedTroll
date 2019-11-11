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
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ListenerItemHighJump implements Listener
{
    // PlayerInteract listener.
    @EventHandler
    public void onInteract (PlayerInteractEvent playerInteractEvent)
    {
        final Player player = playerInteractEvent.getPlayer();
        final Action action = playerInteractEvent.getAction();

        if (player.getInventory().getItemInHand().getItemMeta() != null)
        {
            if (player.getInventory().getItemInHand().getItemMeta().getDisplayName() != null)
            {
                if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§6HighJump"))
                {
                    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
                    {
                        if (!ArrayLists.IS_HIGHJUMPING.contains(player))
                        {
                            ArrayLists.IS_HIGHJUMPING.add(player);
                            if (player.hasPermission("crashedtroll.permissions.troll"))
                            {
                                player.setAllowFlight(true);
                                player.setVelocity(player.getLocation().getDirection().multiply(2.34).setY(1.3));
                                player.playSound(player.getLocation(), Sound.CHICKEN_WALK, 200, 200);
                                player.setAllowFlight(false);
                                StringUtils.sendPlayerMessage(player, "§aBounce Bounce...");
                            }
                            else
                            {
                                StringUtils.sendPlayerMessage(player, "§cYou don´t have Permissions to use this Tool!");
                            }
                        }
                        else
                        {
                            if (player.hasPermission("crashedtroll.permissions.troll"))
                            {
                                player.setAllowFlight(true);
                                player.setVelocity(player.getLocation().getDirection().multiply(2.34).setY(1.3));
                                player.playSound(player.getLocation(), Sound.CHICKEN_WALK, 200, 200);
                                player.setAllowFlight(false);
                                StringUtils.sendPlayerMessage(player, "§aBounce Bounce...");
                            }
                            else
                            {
                                StringUtils.sendPlayerMessage(player, "§cYou don´t have Permissions to use this Tool!");
                            }
                        }
                    }
                }
            }
        }
    }

    // Damage listener.
    @EventHandler
    public void onDamage (EntityDamageEvent entityDamageEvent)
    {
        if (entityDamageEvent.getEntity() instanceof Player)
        {
            final Player player = (Player) entityDamageEvent.getEntity();

            if (ArrayLists.IS_HIGHJUMPING.contains(player))
            {
                if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL)
                {
                    ArrayLists.IS_HIGHJUMPING.remove(player);
                    entityDamageEvent.setCancelled(true);
                }

                if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL)
                {
                    ArrayLists.IS_HIGHJUMPING.remove(player);
                    entityDamageEvent.setCancelled(true);
                }
            }
        }
    }
}
