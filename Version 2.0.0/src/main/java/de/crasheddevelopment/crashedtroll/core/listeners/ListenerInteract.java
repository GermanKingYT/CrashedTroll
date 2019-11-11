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

import de.crasheddevelopment.crashedtroll.utils.ItemUtils;
import de.crasheddevelopment.crashedtroll.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ListenerInteract implements Listener
{
    // Initialize variables.
    private final Inventory gui = Bukkit.createInventory(null, 9, "§cTroll Menu");
    private final ItemUtils itemUtils = new ItemUtils();

    // Loads the gui
    private void loadGui ()
    {
        if (gui.getName().equals("§cTroll Menu"))
        {
            gui.setItem(0, itemUtils.getGuiItemEmptySlots());
            gui.setItem(1, itemUtils.getGuiItemVanish());
            gui.setItem(2, itemUtils.getGuiItemEmptySlots());
            gui.setItem(3, itemUtils.getGuiItemHighJump());
            gui.setItem(4, itemUtils.getGuiItemEmptySlots());
            gui.setItem(5, itemUtils.getGuiItemTeamChat());
            gui.setItem(6, itemUtils.getGuiItemEmptySlots());
            gui.setItem(7, itemUtils.getGuiItemEmptySlots());
            gui.setItem(8, itemUtils.getGuiItemEmptySlots());
        }
    }

    // PlayerInteract listener.
    @EventHandler
    public void onInteract (PlayerInteractEvent playerInteractEvent)
    {
        // Initialize variable.
        final Player player = playerInteractEvent.getPlayer();
        final Action action = playerInteractEvent.getAction();

        // Load gui.
        loadGui();

        // Interact method.
        if (player.getInventory().getItemInHand().getItemMeta() != null)
        {
            if (player.getInventory().getItemInHand().getItemMeta().getDisplayName() != null)
            {
                if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§cTroll-Menu"))
                {
                    if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
                    {
                        if (player.hasPermission("crashedtroll.permissions.troll"))
                        {
                            player.openInventory(gui);
                            player.playSound(player.getLocation(), Sound.CLICK, 200, 100);
                            playerInteractEvent.setCancelled(true);
                        }
                        else
                        {
                            StringUtils.sendPlayerMessage(player, "§cYou do not have permissions to use this tool!");
                        }
                    }
                }
            }
        }
    }

    // Inventory click listener.
    @EventHandler
    public void onClickGui (InventoryClickEvent inventoryClickEvent)
    {
        final Player player = (Player) inventoryClickEvent.getWhoClicked();
        final ItemStack itemStack = inventoryClickEvent.getCurrentItem();

        if (inventoryClickEvent.getInventory().getName().equals("§cTroll Menu"))
        {
            if (inventoryClickEvent.getWhoClicked() instanceof Player)
            {
                if (itemStack.hasItemMeta())
                {
                    if (inventoryClickEvent.getRawSlot() == 0)
                    {
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 1)
                    {
                        Bukkit.dispatchCommand(player, "troll vanish");
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 2)
                    {
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 3)
                    {
                        Bukkit.dispatchCommand(player, "troll highjump");
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 4)
                    {
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 5)
                    {
                        Bukkit.dispatchCommand(player, "troll teamchat");
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 6)
                    {
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 7)
                    {
                        player.closeInventory();
                    }

                    if (inventoryClickEvent.getRawSlot() == 8)
                    {
                        player.closeInventory();
                    }
                }
            }
        }
    }
}