package me.beargoesham.tags;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.backends.file.FileConfig;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {




    boolean hasTag;

    String prefix;
    File file;
    FileConfiguration configuration;

    public FileManager(File file, FileConfiguration ymlConfig)
    {
        this.file = file;
        this.configuration = ymlConfig;
        saveCustomYml(ymlConfig, file);
    }

    public void saveCustomYml(FileConfiguration ymlConfig, File ymlFile)
    {
        file = ymlFile;
        configuration = ymlConfig;

        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Tag getTag(UUID uuid)
    {
        String raw = configuration.getString(uuid.toString());

        return Tag.valueOf(raw);
    }

    public void setTag(UUID uuid, Tag tag)
    {
        configuration.set(uuid.toString(), tag.name());
    }
    //public boolean doesHaveTag(Player player)
    //{
        //return this.hasTag;
    //}
}