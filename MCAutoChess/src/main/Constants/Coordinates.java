package main.Constants;

import main.MCAutoChess;
import org.bukkit.Location;
import org.bukkit.World;

public class Coordinates {
    
    private MCAutoChess plugin;
    private World world;
    
    public Coordinates(MCAutoChess plugin){
        this.plugin = plugin;
        this.world = plugin.getServer().getWorld("MCAutoChess");
    }
    
    public static int PLAYER1_SPAWN_X = 15;
    public static int PLAYER1_SPAWN_Y = 109;
    public static int PLAYER1_SPAWN_Z = -22;
    public Location getPlayer1Spawn(){
        return new Location(world,PLAYER1_SPAWN_X,PLAYER1_SPAWN_Y,PLAYER1_SPAWN_Z);
    }

    public static int PLAYER2_SPAWN_X = 15;
    public static int PLAYER2_SPAWN_Y = 109;
    public static int PLAYER2_SPAWN_Z = 0;
    public Location getPlayer2Spawn(){
        return new Location(world,PLAYER2_SPAWN_X,PLAYER2_SPAWN_Y,PLAYER2_SPAWN_Z);
    }
    
    public static int PLAYER3_SPAWN_X = 15;
    public static int PLAYER3_SPAWN_Y = 109;
    public static int PLAYER3_SPAWN_Z = 22;
    public Location getPlayer3Spawn(){
        return new Location(world,PLAYER3_SPAWN_X,PLAYER3_SPAWN_Y,PLAYER3_SPAWN_Z);
    }

    public static int PLAYER4_SPAWN_X = -7;
    public static int PLAYER4_SPAWN_Y = 109;
    public static int PLAYER4_SPAWN_Z = -22;
    public Location getPlayer4Spawn(){
        return new Location(world,PLAYER4_SPAWN_X,PLAYER4_SPAWN_Y,PLAYER4_SPAWN_Z);
    }

    public static int PLAYER5_SPAWN_X = -7;
    public static int PLAYER5_SPAWN_Y = 109;
    public static int PLAYER5_SPAWN_Z = 22;
    public Location getPlayer5Spawn(){
        return new Location(world,PLAYER5_SPAWN_X,PLAYER5_SPAWN_Y,PLAYER5_SPAWN_Z);
    }

    public static int PLAYER6_SPAWN_X = -29;
    public static int PLAYER6_SPAWN_Y = 109;
    public static int PLAYER6_SPAWN_Z = -22;
    public Location getPlayer6Spawn(){
        return new Location(world,PLAYER6_SPAWN_X,PLAYER6_SPAWN_Y,PLAYER6_SPAWN_Z);
    }

    public static int PLAYER7_SPAWN_X = -29;
    public static int PLAYER7_SPAWN_Y = 109;
    public static int PLAYER7_SPAWN_Z = 0;
    public Location getPlayer7Spawn(){
        return new Location(world,PLAYER7_SPAWN_X,PLAYER7_SPAWN_Y,PLAYER7_SPAWN_Z);
    }

    public static int PLAYER8_SPAWN_X = -29;
    public static int PLAYER8_SPAWN_Y = 109;
    public static int PLAYER8_SPAWN_Z = 22;
    public Location getPlayer8Spawn(){
        return new Location(world,PLAYER8_SPAWN_X,PLAYER8_SPAWN_Y,PLAYER8_SPAWN_Z);
    }
}
