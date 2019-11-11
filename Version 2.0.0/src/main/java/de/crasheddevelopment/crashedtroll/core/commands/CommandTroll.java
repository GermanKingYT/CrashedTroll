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

package de.crasheddevelopment.crashedtroll.core.commands;

import de.crasheddevelopment.crashedtroll.utils.ArrayLists;
import de.crasheddevelopment.crashedtroll.utils.ItemUtils;
import de.crasheddevelopment.crashedtroll.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommandTroll implements CommandExecutor
{
    // Initialize variables.
    private final ItemUtils itemUtils = new ItemUtils();
    private final Random random = new Random();

    // Command method.
    @Override
    public boolean onCommand(CommandSender sender, Command c, String s, String[] args)
    {
        // Check if sender is an player.
        if (sender instanceof Player)
        {
            // Initialize variable.
            final Player player = (Player) sender;

            // Check if player has these permissions.
            if (player.hasPermission("crashedtroll.permission.troll"))
            {
                // Check if arguments length is one.
                if (args.length == 1)
                {
                    // Help command.
                    if (args[0].equalsIgnoreCase("help"))
                    {
                        StringUtils.sendPlayerMessage(player, "\n§eHelp:\n§b/troll §etool\n§b/troll §evanish\n\n§b/troll §eteamchat\n§b/troll §ehighjump\n§b/troll §erocket §7<§ePlayer§7>\n§b/troll §eexplode §7<§ePlayer§7>\n§b/troll §efakeop §7<§ePlayer§7>\n§b/troll §espamchat §7<§ePlayer§7>\n§b/troll §efreeze §7<§ePlayer§7>\n§b/troll §efakecheater §7<§ePlayer§7>\n§b/troll §efakeflags §7<§ePlayer§7>\n§b/troll §ehacked §7<§ePlayer§7>\n§b/troll §enoblockbreak §7<§ePlayer§7>\n§b/troll §enoblockplace §7<§ePlayer§7>\n§b/troll §eflipper §7<§ePlayer§7>");
                    }
                    // Tool command
                    else if (args[0].equalsIgnoreCase("tool"))
                    {
                        if (!player.getInventory().contains(itemUtils.getGuiMenuItemStack()))
                        {
                            player.getInventory().addItem(itemUtils.getGuiMenuItemStack());
                            StringUtils.sendPlayerMessage(player, "§aTool received!");
                        }
                        else
                        {
                            StringUtils.sendPlayerMessage(player, "§cYou have already this tool in your inventory!");
                        }
                    }
                    // Vanish command.
                    else if (args[0].equalsIgnoreCase("vanish"))
                    {
                        if (!ArrayLists.IS_VANISHED.contains(player))
                        {
                            ArrayLists.IS_VANISHED.add(player);
                            for (Player allPlayers : Bukkit.getOnlinePlayers())
                            {
                                allPlayers.hidePlayer(player);
                            }
                            StringUtils.sendPlayerMessage(player, "§aYou are vanished now!");
                        }
                        else
                        {
                            ArrayLists.IS_VANISHED.remove(player);
                            for (Player allPlayers : Bukkit.getOnlinePlayers())
                            {
                                allPlayers.showPlayer(player);
                            }
                            StringUtils.sendPlayerMessage(player, "§cYou are not more in vanish!");
                        }
                    }
                    // Team chat command.
                    else if (args[0].equalsIgnoreCase("teamchat"))
                    {
                        if (player.hasPermission("crashedtroll.permission.teamchat"))
                        {
                            if (!ArrayLists.IS_IN_TEAMCHAT.contains(player))
                            {
                                ArrayLists.IS_IN_TEAMCHAT.add(player);
                                StringUtils.sendPlayerMessage(player, "§aYou are now logged in the team chat!");
                                StringUtils.sendTeamBroadcast("§a" + player.getName() + " logged in the team chat!");
                            }
                            else
                            {
                                ArrayLists.IS_IN_TEAMCHAT.remove(player);
                                StringUtils.sendPlayerMessage(player, "§cYou are now logged out the team chat!");
                                StringUtils.sendTeamBroadcast("§c" + player.getName() + " logged out the team chat!");
                            }
                        }
                        else
                        {
                            player.sendMessage(StringUtils.NO_PERMISSIONS);
                        }
                    }
                    // HighJump command.
                    else if (args[0].equalsIgnoreCase("highjump"))
                    {
                        if (!player.getInventory().contains(itemUtils.getGuiItemHighJump()))
                        {
                            player.getInventory().addItem(itemUtils.getGuiItemHighJump());
                            StringUtils.sendPlayerMessage(player, "§aTool received!");
                        }
                        else
                        {
                            StringUtils.sendPlayerMessage(player, "§cYou have already this tool!");
                        }
                    }
                    else
                    {
                        StringUtils.sendPlayerMessage(player, "§cCommand not found! Please enter </troll help> for help!");
                    }
                }
                // Check if arguments length is two.
                else if (args.length == 2)
                {
                    int countPlayer = 0;
                    // Check if the targeted player is online!
                    for (Player targetPlayer : Bukkit.getOnlinePlayers())
                    {
                        if (targetPlayer.getName().equals(args[1]))
                        {
                            countPlayer ++;
                            // Rocket command.
                            if (args[0].equalsIgnoreCase("rocket"))
                            {
                                StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " got whooooosed!");
                                targetPlayer.setAllowFlight(true);
                                targetPlayer.setVelocity(targetPlayer.getLocation().getDirection().multiply(0.5).setY(3.8));
                                targetPlayer.playSound(targetPlayer.getLocation(), Sound.BURP, 100, 25);
                                targetPlayer.setAllowFlight(false);
                            }
                            // Explode command
                            else if (args[0].equalsIgnoreCase("explode"))
                            {
                                StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " exploded!");
                                targetPlayer.playSound(targetPlayer.getLocation(), Sound.FIREWORK_LAUNCH, 100, 200);
                                targetPlayer.getWorld().createExplosion(targetPlayer.getLocation(), 3);
                                targetPlayer.setHealth(0);
                            }
                            // FakeOP command.
                            else if (args[0].equalsIgnoreCase("fakeop"))
                            {
                                StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " thinks he has OP now!");
                                targetPlayer.sendMessage("§7§o[CONSOLE: Opped " + targetPlayer.getName() + "]");
                            }
                            // Spam chat command.
                            else if (args[0].equalsIgnoreCase("spamchat"))
                            {
                                StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " got many messages now in his chat!");
                                for (int xyz = 0; xyz < 5000; xyz++)
                                {
                                    targetPlayer.sendMessage("§c" + random.nextInt(999999999) + " yeet");
                                }
                            }
                            // Freeze command.
                            else if (args[0].equalsIgnoreCase("freeze"))
                            {
                                if (!ArrayLists.IS_FREEZED.contains(targetPlayer))
                                {
                                    ArrayLists.IS_FREEZED.add(targetPlayer);
                                    targetPlayer.setWalkSpeed(0.0F);
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " can not walk anymore!");
                                }
                                else
                                {
                                    ArrayLists.IS_FREEZED.remove(targetPlayer);
                                    targetPlayer.setWalkSpeed(0.2F);
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " can walk again!");
                                }
                            }
                            // Fake cheater command.
                            else if (args[0].equalsIgnoreCase("fakecheater"))
                            {
                                if (!ArrayLists.IS_FAKE_CHEATER.contains(targetPlayer))
                                {
                                    ArrayLists.IS_FAKE_CHEATER.add(targetPlayer);
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " looks like he is cheating!");
                                }
                                else
                                {
                                    ArrayLists.IS_FAKE_CHEATER.remove(targetPlayer);
                                    targetPlayer.setWalkSpeed(0.2F);
                                    targetPlayer.setAllowFlight(false);
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " looks not more like he is cheating!");
                                }
                            }
                            // Fake flags command.
                            else if (args[0].equalsIgnoreCase("fakeflags"))
                            {
                                if (!ArrayLists.IS_FAKE_FLAGGING.contains(targetPlayer))
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " is fake flagging now!");
                                    ArrayLists.IS_FAKE_FLAGGING.add(targetPlayer);
                                }
                                else
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " is not fake flagging more!");
                                    ArrayLists.IS_FAKE_FLAGGING.remove(targetPlayer);
                                }
                            }
                            // Hacked command.
                            else if (args[0].equalsIgnoreCase("hacked"))
                            {
                                if (!ArrayLists.IS_HACKED.contains(targetPlayer))
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " thinks now that this server got hacked!");
                                    ArrayLists.IS_HACKED.add(targetPlayer);
                                    try
                                    {
                                        targetPlayer.sendMessage("§7§o[RCON: 127.0.0.1 connected to RCON!]");
                                        TimeUnit.SECONDS.sleep(random.nextInt(5));
                                        targetPlayer.sendMessage("§7§o[127.0.0.1: Installing VIRUS.jar...]");
                                        TimeUnit.SECONDS.sleep(random.nextInt(8));
                                        targetPlayer.sendMessage("§7§o[127.0.0.1: VIRUS.jar installed!]");
                                        TimeUnit.SECONDS.sleep(random.nextInt(2));
                                        targetPlayer.sendMessage("§7§o[CONSOLE: §cPlease note that this command is not supported and may cause issues when using some plugins.§7§o]");
                                        targetPlayer.sendMessage("§7§o[CONSOLE: §cIf you encounter any issues please use the /stop command to restart your server.§7§o]");
                                        TimeUnit.SECONDS.sleep(random.nextInt(10));
                                        targetPlayer.sendMessage("§7§o[CONSOLE: §aReload complete.§7§o]");
                                    }
                                    catch (Exception exception)
                                    {
                                        StringUtils.sendInformation("Exception while troll target player.");
                                        exception.printStackTrace();
                                    }
                                }
                                else
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " thinks not more now that this server got hacked!");
                                    ArrayLists.IS_HACKED.remove(targetPlayer);
                                }
                            }
                            // NoBlockBreak command.
                            else if (args[0].equalsIgnoreCase("noblockbreak"))
                            {
                                if (!ArrayLists.IS_IN_NO_BLOCK_BREAK.contains(targetPlayer))
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " can not break blocks anymore!");
                                    ArrayLists.IS_IN_NO_BLOCK_BREAK.add(targetPlayer);
                                }
                                else
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " can break blocks again!");
                                    ArrayLists.IS_IN_NO_BLOCK_BREAK.remove(targetPlayer);
                                }
                            }
                            // NoBlockPlace command.
                            else if (args[0].equalsIgnoreCase("noblockplace"))
                            {
                                if (!ArrayLists.IS_IN_NO_BLOCK_PLACE.contains(targetPlayer))
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " can not place blocks anymore!");
                                    ArrayLists.IS_IN_NO_BLOCK_PLACE.add(targetPlayer);
                                }
                                else
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " can place blocks again!");
                                    ArrayLists.IS_IN_NO_BLOCK_PLACE.remove(targetPlayer);
                                }
                            }
                            // Flipper command.
                            else if (args[0].equalsIgnoreCase("flipper"))
                            {
                                if (!ArrayLists.IS_FLIPPING.contains(targetPlayer))
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " is now flipping around!");
                                    ArrayLists.IS_FLIPPING.add(targetPlayer);
                                }
                                else
                                {
                                    StringUtils.sendPlayerMessage(player, "§a" + targetPlayer.getName() + " is now not more flipping around!");
                                    ArrayLists.IS_FLIPPING.remove(targetPlayer);
                                }
                            }
                            else
                            {
                                StringUtils.sendPlayerMessage(player, "§cCommand not found! Please enter </troll help> for help!");
                            }
                        }
                    }

                    // If the player is not online.
                    if (countPlayer == 0)
                    {
                        player.sendMessage(StringUtils.PLAYER_OFFLINE);
                    }
                }
                else
                {
                    StringUtils.sendPlayerMessage(player, "§cCommand not found! Please enter </troll help> for help!");
                }
            }
            else
            {
                player.sendMessage(StringUtils.NO_PERMISSIONS);
            }
        }
        else
        {
            StringUtils.sendInformation("You do not have permissions to execute this command!");
        }
        return true;
    }
}