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

package de.crasheddevelopment.crashedtroll.core.updater;

import de.crasheddevelopment.crashedtroll.utils.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class PluginUpdateSearcher
{
    public PluginUpdateSearcher ()
    {
        searchUpdate();
    }

    private void searchUpdate ()
    {
        try
        {
            // Initialize variables.
            // Connect to the URL.
            final URL url = new URL("https://api.github.com/repos/CrashedDevelopment/SyncMe/releases/latest");
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String source;

            // Read website content.
            while ((source = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(source);
            }

            // Splits website content.
            String[] source1 = stringBuilder.toString().split("\"browser_download_url\":");
            String[] source2 = source1[1].split("}],\"tarball_url\":");
            String source3 = source2[0].replace("\"", "");

            // Checks if the latest version not contains with the plugin version.
            if (!source3.contains(StringUtils.VERSION))
            {
                // Sends console messages.
                StringUtils.sendInformation("Update available!");
                StringUtils.sendInformation("Download it under: https://github.com/crasheddevelopment/CrashedTroll/releases/latest");
            }
            else
            {
                // Send console message.
                StringUtils.sendInformation("No update is available!");
            }
        }
        catch (Exception exception)
        {
            // Plugin exception.
            // Prints the exception.
            StringUtils.sendInformation("Exception!");
            exception.printStackTrace();
        }
    }
}