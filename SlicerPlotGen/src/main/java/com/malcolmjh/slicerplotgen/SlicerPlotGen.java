package com.malcolmjh.slicerplotgen;

import com.malcolmjh.slicerplotgen.commands.claimCommand;
import com.malcolmjh.slicerplotgen.listeners.blockPlaceListener;
import com.malcolmjh.slicerplotgen.listeners.blockRemoveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlicerPlotGen extends JavaPlugin {
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new blockPlaceListener(this), this);
        getServer().getPluginManager().registerEvents(new blockRemoveListener(this), this);
        getCommand("claim").setExecutor(new claimCommand(this));
    }
}
