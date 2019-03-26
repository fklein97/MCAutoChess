package main.Commands;

import main.MCAutoChess;
import main.Mode.ModeHandler;
import org.bukkit.entity.Player;

public class Commands {

    public static void join(Player p, MCAutoChess plugin){
        if(plugin.getStatus() == plugin.STATUS_NOT_RUNNING && plugin.queue.size() < 8) {
            if(plugin.queue.contains(p)){
                p.sendMessage("You are already in the queue");
            }
            else {
                plugin.queue.add(p);
                plugin.getServer().broadcastMessage(p.getDisplayName() + " has joined the MCAC queue " + "(" + plugin.queue.size() + "/8)");
            }
        }
        else if(plugin.getStatus() == plugin.STATUS_RUNNING){
            p.sendMessage("Game is already running. Could not join the queue");
        }
    }

    public static void start(Player p, MCAutoChess plugin){
        ModeHandler modeHandler = new ModeHandler(plugin);
        modeHandler.startGame();
    }

    public static void buildmode(MCAutoChess plugin){
        plugin.toggleBuildmode();
        plugin.getServer().broadcastMessage("BuildMode: " + plugin.getBuilmode());
    }
}
