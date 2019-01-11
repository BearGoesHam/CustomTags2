package me.beargoesham.tags;

import org.bukkit.ChatColor;

public enum Tag
{

    TRYHARD("&7[&d&lTRYHARD&l]"),
    FUN("&7[&d&lFUN&7]");

    String tag;
    private Tag(String tag)
    {
        this.tag = tag;
    }
    public String getTag()
    {
        return ChatColor.translateAlternateColorCodes('&', this.tag);
    }

}
