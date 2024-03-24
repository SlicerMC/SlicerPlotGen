package com.malcolmjh.slicerplotgen.listeners;

import com.malcolmjh.slicerplotgen.SlicerPlotGen;
import com.malcolmjh.slicerplotgen.net.API;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import java.util.UUID;

public class blockPlaceListener implements Listener {
    private static SlicerPlotGen plugin;
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerBlockPlace(BlockPlaceEvent e) {
        Player p = (Player) e.getPlayer();
        UUID UUID = p.getUniqueId();
        String xpos = String.valueOf(e.getBlock().getX());
        String returnedxpos = String.valueOf(API.getXposByPlayerID(UUID, plugin));
        if (xpos != null && !(returnedxpos.equals(xpos) || p.isOp() || p.hasPermission("slicer.staff.slicehelp"))) {
            e.setCancelled(true);
        } else if (xpos == null) {
            e.setCancelled(true);
            p.sendMessage("Hmmm... That's an error! 'NullXposBPL'");
        }
    }
}
