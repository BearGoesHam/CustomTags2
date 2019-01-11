package me.beargoesham.tags;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{


    private FileManager fileManager;

    public void onEnable()
    {
        registerCommands();
        registerListeners();
    }
    public void onDisable()
    {

    }
    public void registerCommands()
    {
        getCommand("prefix").setExecutor(new TagCommand(this));
    }
    public void registerListeners()
    {
        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new TagChatListener(this), this);
    }

    public static boolean isValid(String value) {
        for (Tag tag : Tag.values()) {
            if (tag.name().equals(value)) {
                return true;
            }
        }
        return true;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

}

