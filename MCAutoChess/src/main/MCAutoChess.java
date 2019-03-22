package main;

import main.Commands.CommandHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MCAutoChess extends JavaPlugin {

    private void registerListener() {

    }

    @Override
    public void onEnable() {
        System.out.println(this.getDescription().getFullName() + " " + this.getDescription().getVersion() + " enabled!");
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
