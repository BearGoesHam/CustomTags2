package me.beargoesham.tags;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.backends.file.FileConfig;

import java.io.File;

public class TagCommand implements CommandExecutor
{
    private Main main;

    File playerFile = new File(main.getDataFolder() + "prefixdata.yml");
    FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);

    public TagCommand(Main main)
    {
        this.main = main;
    }
    FileManager manager = new FileManager(playerFile, playerConfig);


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("prefix"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("prefix.use"))
                {
                    if (args.length == 3)
                    {
                        if (args[0].equalsIgnoreCase("grant") || args[0].equalsIgnoreCase("set"))
                        {
                            OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                            if (target.hasPlayedBefore())
                            {
                                if (main.isValid(args[2].toUpperCase()))
                                {
                                    Tag tag = Tag.valueOf(args[2].toUpperCase());
                                    main.getFileManager().setTag(target.getUniqueId(), tag);
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[TAGS] You have set " + target.getName() + "'s prefix to: " + tag));
                                }
                            } else
                                {
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[TAGS] Player " + args[1] + "has never played before"));
                                }
                        }
                    } else
                        {
                            p.sendMessage(ChatColor.RED + "[TAGS] Usage: /prefix grant/set <player> <tag>");
                        }
                }
            }
        }
        return false;
    }

}
