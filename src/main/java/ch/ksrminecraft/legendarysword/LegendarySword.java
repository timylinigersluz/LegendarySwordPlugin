package ch.ksrminecraft.legendarysword;

import ch.ksrminecraft.legendarysword.commands.SwordCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class LegendarySword extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("legendary").setExecutor(new SwordCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
