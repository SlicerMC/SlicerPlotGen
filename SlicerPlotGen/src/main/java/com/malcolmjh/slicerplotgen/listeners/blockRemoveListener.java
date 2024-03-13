package com.malcolmjh.slicerplotgen.listeners;

import com.malcolmjh.slicerplotgen.net.API;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import java.util.UUID;

public class blockRemoveListener implements Listener {
    @EventHandler
    public void onPlayerBlockRemove(BlockBreakEvent e) {
        Player p = (Player) e.getPlayer();
        UUID UUID = p.getUniqueId();
        String xpos = String.valueOf(e.getBlock().getX());
        String returnedxpos = String.valueOf(API.getXposByPlayerID(UUID));
        if (xpos != null && !(returnedxpos.equals(xpos) || p.isOp() || p.hasPermission("slicer.staff.slicehelp"))) {
            e.setCancelled(true);
        } else if (xpos == null) {
            e.setCancelled(true);
            p.sendMessage("Hmmm... That's an error! 'NullXposBRL'");
        }
    }
}
