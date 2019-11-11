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

package de.crasheddevelopment.crashedtroll;

import de.crasheddevelopment.crashedtroll.core.commands.CommandTroll;
import de.crasheddevelopment.crashedtroll.core.commands.CommandVersion;
import de.crasheddevelopment.crashedtroll.core.listeners.*;
import de.crasheddevelopment.crashedtroll.core.updater.PluginUpdateSearcher;
import de.crasheddevelopment.crashedtroll.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CrashedTroll extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        // Sends output.
        System.out.println("\n" +
                "_________                      .__               .______________             .__  .__   \n" +
                "\\_   ___ \\____________    _____|  |__   ____   __| _/\\__    ___/______  ____ |  | |  |  \n" +
                "/    \\  \\/\\_  __ \\__  \\  /  ___/  |  \\_/ __ \\ / __ |   |    |  \\_  __ \\/  _ \\|  | |  |  \n" +
                "\\     \\____|  | \\// __ \\_\\___ \\|   Y  \\  ___// /_/ |   |    |   |  | \\(  <_> )  |_|  |__\n" +
                " \\______  /|__|  (____  /____  >___|  /\\___  >____ |   |____|   |__|   \\____/|____/____/\n" +
                "        \\/            \\/     \\/     \\/     \\/     \\/                                    " +
                " ");
        System.out.println("***************************************************");
        StringUtils.sendInformation("Copyright © 2019 CrashedDevelopment");
        StringUtils.sendInformation("This is an non-commercial project.");
        StringUtils.sendInformation("All rights belong to their respective owners.");
        System.out.println("***************************************************");
        StringUtils.sendInformation("Running in version: v" + StringUtils.VERSION);
        StringUtils.sendInformation("Running in build version: b" + StringUtils.BUILD);
        System.out.println(" ");

        // Searching for an update.
        StringUtils.sendInformation("Searching for an update...");
        runUpdater();

        // Loading commands.
        StringUtils.sendInformation("Plugin : Loading [1/2]: Loading commands...");
        loadCommands();

        // Loading listeners.
        StringUtils.sendInformation("Plugin : Loading [2/2]: Loading listeners...");
        loadListeners();

        // Send output.
        StringUtils.sendInformation("Plugin enabled!");
    }

    @Override
    public void onDisable()
    {
        // Send output.
        StringUtils.sendInformation("Plugin disabled!");
    }

    private void loadCommands ()
    {
        // Register commands & sends output.
        StringUtils.sendInformation("Plugin : Registering [1/2]: Register class CommandTroll.java...");
        Bukkit.getPluginCommand("troll").setExecutor(new CommandTroll());
        StringUtils.sendInformation("Plugin : Registered [1/2]: Registered class CommandTroll.java!");
        StringUtils.sendInformation("Plugin : Registering [1/2]: Register class CommandVersion.java...");
        Bukkit.getPluginCommand("crashedtroll").setExecutor(new CommandVersion());
        StringUtils.sendInformation("Plugin : Registered [1/2]: Registered class CommandVersion.java!");
        StringUtils.sendInformation("Plugin : Loaded [1/2]: Loaded commands!");
        System.out.println(" ");
    }

    private void loadListeners ()
    {
        // Register listeners & sends output.
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerJoin.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerJoin(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerJoin.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerBlockBreak.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerBlockBreak(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerBlockBreak.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerTeamChat.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerTeamChat(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerTeamChat.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerServerFakeHacked.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerServerFakeHacked(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerServerFakeHacked.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerInteract.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerInteract(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerInteract.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerItemHighJump.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerItemHighJump(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerItemHighJump.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerMoveFakeCheater.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerMoveFakeCheater(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerMoveFakeCheater.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerMoveFakeFlagging.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerMoveFakeFlagging(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerMoveFakeFlagging.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerMoveFlipper.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerMoveFlipper(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerMoveFlipper.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerBlockPlace.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerBlockPlace(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerBlockPlace.java!");
        StringUtils.sendInformation("Plugin : Registering [2/2]: Register class ListenerQuit.java...");
        Bukkit.getPluginManager().registerEvents(new ListenerQuit(), this);
        StringUtils.sendInformation("Plugin : Registered [2/2]: Registered class ListenerQuit.java!");
        StringUtils.sendInformation("Plugin : Loaded [2/2]: Loaded listeners!");
        System.out.println(" ");
    }

    private void runUpdater ()
    {
        // Search update.
        new PluginUpdateSearcher();
        System.out.println(" ");
    }
}