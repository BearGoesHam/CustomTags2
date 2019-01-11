package me.beargoesham.tags;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TagChatListener implements Listener
{

    private Main main;
    public TagChatListener(Main main)
    {
        this.main = main;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();
        String message = e.getMessage();
        Tag tag = main.getFileManager().getTag(p.getUniqueId());


    }

}
