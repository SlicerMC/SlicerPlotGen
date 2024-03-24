package com.malcolmjh.slicerplotgen.commands;

import com.malcolmjh.slicerplotgen.SlicerPlotGen;
import com.malcolmjh.slicerplotgen.net.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.UUID;

public class claimCommand implements CommandExecutor {
    private static SlicerPlotGen plugin;
    public claimCommand(SlicerPlotGen plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player p = (Player) sender;
        int xpos = p.getPlayer().getLocation().getBlockX();
        UUID UUID = p.getUniqueId();
        String stuff = API.setSliceOwnerByXpos(UUID, xpos, plugin);
        p.sendMessage(stuff);
        return true;
    }
}
