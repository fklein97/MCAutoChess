package main;

import main.Commands.CommandHandler;
import main.Listeners.WorldListener;
import main.Mode.ChessPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class MCAutoChess extends JavaPlugin {

    WorldListener wl;
    private void registerListener() {
        wl = new WorldListener(this);
    }

    @Override
    public void onEnable() {
        System.out.println(this.getDescription().getFullName() + " " + this.getDescription().getVersion() + " enabled!");
        queue = new ArrayList<Player>();
        registerListener();
    }

    @Override
    public void onDisable() {
        saveConfigChanges();
        System.out.println(this.getDescription().getFullName() + " " + this.getDescription().getVersion() + " disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandHandler cmdHandler = new CommandHandler(this);
        return cmdHandler.handleCommand(sender,command,args);
    }

    public void saveConfigChanges(){
        this.saveConfig();
//        this.reloadConfig();
    }

    public ArrayList<Player> queue;
    public ArrayList<ChessPlayer> chessplayers;


    public static int STATUS_NOT_RUNNING = 0;
    public static int STATUS_RUNNING = 1;

    private int status = STATUS_NOT_RUNNING;

    public int getStatus(){
        return status;
    }

    public void setStatusRunning(){
        status = STATUS_RUNNING;
    }

    public void setStatusNotRunning(){
        status = STATUS_NOT_RUNNING;
    }
}
