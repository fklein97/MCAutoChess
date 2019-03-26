package main.Listeners;

import main.MCAutoChess;
import main.Mode.ChessPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    private MCAutoChess plugin;

    public PlayerListener(MCAutoChess plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().startsWith(ChatColor.AQUA + "[Right Click]")){
            for(ChessPlayer cp : plugin.chessplayers){
                if(cp.getPlayer() == event.getPlayer()){
                    if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.MAP){
                        //TODO open Chesspiece Move Interface
                        event.setCancelled(true);
                    }
                    else if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.CHEST){
                        //TODO open Shop Interface
                        event.setCancelled(true);
                    }
                    else if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.EXPERIENCE_BOTTLE){
                        cp.buyXP();
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if(event.getPlayer() != null){
            if(plugin.chessplayers != null) {
                for (ChessPlayer cp : plugin.chessplayers) {
                    if (cp.getPlayer() == event.getPlayer()) {
                        event.setCancelled(true);
                        break;
                    }
                }
            }
            if(!plugin.getBuilmode()){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(event.getPlayer() != null){
            if(plugin.chessplayers != null) {
                for (ChessPlayer cp : plugin.chessplayers) {
                    if (cp.getPlayer() == event.getPlayer()) {
                        event.setCancelled(true);
                        break;
                    }
                }
            }
            if(!plugin.getBuilmode()){
                event.setCancelled(true);
            }
        }
    }

}
