package main.Commands;

import main.MCAutoChess;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {

    private MCAutoChess plugin;

    public CommandHandler(MCAutoChess plugin){
        this.plugin = plugin;
    }

    public boolean handleCommand(CommandSender sender , Command command, String[] args){

        return true;
    }
}
