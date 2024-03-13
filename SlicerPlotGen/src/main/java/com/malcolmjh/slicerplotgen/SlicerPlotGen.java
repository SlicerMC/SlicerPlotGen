package com.malcolmjh.slicerplotgen;

import com.malcolmjh.slicerplotgen.commands.claimCommand;
import com.malcolmjh.slicerplotgen.listeners.blockPlaceListener;
import com.malcolmjh.slicerplotgen.listeners.blockRemoveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlicerPlotGen extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[START UP-LOADING] [INFO]: Slicer Plot Gen Is Loading...");
        getLogger().info("[START UP-1] [INFO]: Slicer Plot Gen Is Starting The Listeners...");
        getServer().getPluginManager().registerEvents(new blockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new blockRemoveListener(), this);
        getLogger().info("[START UP-2] [INFO]: Slicer Plot Gen Has Started The Listeners!");
        getLogger().info("[START UP-3] [INFO]: Slicer Plot Gen Is Starting The Commands...");
        getCommand("claim").setExecutor(new claimCommand());
        getLogger().info("[START UP-4] [INFO]: Slicer Plot Gen Has Started The Commands!");
        getLogger().info("[START UP-FINAL] [INFO]: Slicer Plot Gen Has Started!");
    }
}
