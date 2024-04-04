package org.kyabori;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.kyabori.commands.live;
import org.kyabori.commands.setlink;

public class Main extends JavaPlugin {
    @Getter
    static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setlink").setExecutor(new setlink());
        getCommand("live").setExecutor(new live());
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}

