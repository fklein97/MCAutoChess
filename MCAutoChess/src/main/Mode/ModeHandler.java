package main.Mode;

import main.Constants.Coordinates;
import main.MCAutoChess;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ModeHandler {

    private MCAutoChess plugin;

    public ModeHandler (MCAutoChess plugin){
        this.plugin = plugin;
    }

    public void startGame(){
        plugin.setStatusRunning();
        int i = 1;
        Coordinates coodts = new Coordinates(plugin);

        plugin.chessplayers = new ArrayList<ChessPlayer>();
        for(Player p : plugin.queue){
            ChessPlayer cp = new ChessPlayer(p,i);
            switch(cp.getPlayernumber()) {
                case 1:
                    cp.setSpawn(coodts.getPlayer1Spawn());
                    break;
                case 2:
                    cp.setSpawn(coodts.getPlayer2Spawn());
                    break;
                case 3:
                    cp.setSpawn(coodts.getPlayer3Spawn());
                    break;
                case 4:
                    cp.setSpawn(coodts.getPlayer4Spawn());
                    break;
                case 5:
                    cp.setSpawn(coodts.getPlayer5Spawn());
                    break;
                case 6:
                    cp.setSpawn(coodts.getPlayer6Spawn());
                    break;
                case 7:
                    cp.setSpawn(coodts.getPlayer7Spawn());
                    break;
                case 8:
                    cp.setSpawn(coodts.getPlayer8Spawn());
                    break;
            }
            plugin.chessplayers.add(cp);
            i++;
        }

        for(ChessPlayer cp : plugin.chessplayers){
            cp.getPlayer().teleport(cp.getSpawn());
            cp.refreshPlayerInformation();
        }
    }
}
