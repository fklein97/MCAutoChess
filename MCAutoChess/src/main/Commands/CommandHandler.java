package main.Commands;

import main.MCAutoChess;
import main.Mode.ChessPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler {

    private MCAutoChess plugin;

    public CommandHandler(MCAutoChess plugin){
        this.plugin = plugin;
    }

    public boolean handleCommand(CommandSender sender , Command command, String[] args){
        Player p = null;
        if (sender instanceof Player){
           p = (Player) sender;
        }
        else{
            return false;
        }

        if(command.getName().equals("mcac")){
            if(args.length == 0){

            }
            else if(args.length == 1){
                if(args[0].equals("join") || args[0].equals("j")){
                    Commands.join(p, plugin);
                }
                else if(args[0].equals("start")){
                    Commands.start(p, plugin);
                }
            }
            else if (args.length == 2) {

            }
            else if(args.length == 3){






                if(args[0].equals("debug")){
                    if(args[1].equals("addmoney")){
                        for(ChessPlayer cp : plugin.chessplayers){
                            if(cp.getPlayer() == p){
                                cp.addMoney(Integer.parseInt(args[2]));
                            }
                        }
                    }
                }
            }
        }


        return true;
    }
}
