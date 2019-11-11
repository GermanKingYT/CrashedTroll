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

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils
{
    // Initialize variables.
    private final ItemStack guiMenuItemStack = new ItemStack(Material.BOOK);
    private final ItemStack guiItemVanish = new ItemStack(Material.GOLDEN_APPLE);
    private final ItemStack guiItemHighJump = new ItemStack(Material.FEATHER);
    private final ItemStack guiItemTeamChat = new ItemStack(Material.CHEST);
    private final ItemStack guiItemEmptySlots = new ItemStack(Material.THIN_GLASS);

    // Set items methods.
    private void setItems ()
    {
        // Initialize variables.
        final ItemMeta menuItemMeta = guiMenuItemStack.getItemMeta();
        final ItemMeta vanishItemMeta = guiItemVanish.getItemMeta();
        final ItemMeta highJumpItemMeta = guiItemHighJump.getItemMeta();
        final ItemMeta teamChatItemMeta = guiItemTeamChat.getItemMeta();
        final ItemMeta emptySlotsItemMeta = guiItemEmptySlots.getItemMeta();

        // Display name of the items.
        menuItemMeta.setDisplayName("§cTroll-Menu");
        vanishItemMeta.setDisplayName("§bVanish");
        highJumpItemMeta.setDisplayName("§6HighJump");
        teamChatItemMeta.setDisplayName("§5TeamChat");
        emptySlotsItemMeta.setDisplayName("§cEmpty");

        // Set item meta.
        guiMenuItemStack.setItemMeta(menuItemMeta);
        guiItemVanish.setItemMeta(vanishItemMeta);
        guiItemHighJump.setItemMeta(highJumpItemMeta);
        guiItemTeamChat.setItemMeta(teamChatItemMeta);
        guiItemEmptySlots.setItemMeta(emptySlotsItemMeta);
    }

    // Return items.
    public ItemStack getGuiMenuItemStack()
    {
        setItems();
        return guiMenuItemStack;
    }

    public ItemStack getGuiItemVanish()
    {
        setItems();
        return guiItemVanish;
    }

    public ItemStack getGuiItemHighJump()
    {
        setItems();
        return guiItemHighJump;
    }

    public ItemStack getGuiItemTeamChat()
    {
        setItems();
        return guiItemTeamChat;
    }

    public ItemStack getGuiItemEmptySlots()
    {
        setItems();
        return guiItemEmptySlots;
    }
}