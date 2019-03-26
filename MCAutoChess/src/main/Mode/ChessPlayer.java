package main.Mode;

import main.Interface.SpecialItemsGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ChessPlayer {
    private int playernumber;
    private Player p;
    private Location spawn;
    private int money;
    private int xp;
    private int level;
    private int health;

    public ChessPlayer(Player p, int playernumber) {
        this(p, playernumber, null);
    }

    public ChessPlayer(Player p, int playernumber, Location spawn) {
        this.playernumber = playernumber;
        this.p = p;
        this.spawn = spawn;
        this.money = 1;
        this.xp = 0;
        this.level = 1;
        this.health = 100;
        refreshPlayerInformation();
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public Player getPlayer() {
        return p;
    }

    public Location getSpawn() {
        return spawn;
    }

    public int getMoney() {
        return money;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public float getLevelPercentage(){
        float percentage;
        float level_xp = 0;
        float needed_xp = 1;


        if(this.level == 1){
            level_xp = this.xp - 0;
            needed_xp = 1;
        }
        else if(this.level == 2){
            level_xp = this.xp - 1;
            needed_xp = 1;
        }
        else if(this.level == 3){
            level_xp = this.xp - 2;
            needed_xp = 2;
        }
        else if(this.level == 4){
            level_xp = this.xp - 4;
            needed_xp = 4;
        }
        else if(this.level == 5){
            level_xp = this.xp - 8;
            needed_xp = 8;
        }
        else if(this.level == 6){
            level_xp = this.xp - 16;
            needed_xp = 16;
        }
        else if(this.level == 7){
            level_xp = this.xp - 32;
            needed_xp = 24;
        }
        else if(this.level == 8){
            level_xp = this.xp - 56;
            needed_xp = 32;
        }
        else if(this.level == 9){
            level_xp = this.xp - 88;
            needed_xp = 40;
        }
        else if(this.level == 10){
            level_xp = 0;
            needed_xp = 100;
        }

        percentage = level_xp/needed_xp;
        return percentage;
    }

    public int getHealth() {
        return health;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public void setXp(int xp) {
        this.xp = xp;
        refreshPlayerInformation();
    }

    public void setMoney(int money) {
        this.money = money;
        refreshPlayerInformation();
    }

    public void takeDamage(int amount){
        this.health = this.health - amount;
        refreshPlayerInformation();
    }

    public void addXp(int amount) {
        this.xp = this.xp + amount;
        refreshLevel();
        refreshPlayerInformation();
    }

    public void addMoney(int amount) {
        this.money = this.money + amount;
        refreshPlayerInformation();
    }

    public void buyXP(){
        if(money >= 5){
            money = money - 5;
            xp = xp + 4;
        }
        refreshLevel();
        refreshPlayerInformation();
    }

    public void refreshLevel(){
        if(xp >= 0 && xp < 1){
            this.level = 1;
        }
        else if(xp >= 1 && xp < 2){
            this.level = 2;
        }
        else if(xp >= 2 && xp < 4){
            this.level = 3;
        }
        else if(xp >= 4 && xp < 8){
            this.level = 4;
        }
        else if(xp >= 8 && xp < 16){
            this.level = 5;
        }
        else if(xp >= 16 && xp < 32){
            this.level = 6;
        }
        else if(xp >= 32 && xp < 56){
            this.level = 7;
        }
        else if(xp >= 56 && xp < 88){
            this.level = 8;
        }
        else if(xp >= 88 && xp < 128){
            this.level = 9;
        }
        else if(xp >= 128){
            this.level = 10;
        }
    }

    public void refreshPlayerInformation(){
        SpecialItemsGenerator sigen = new SpecialItemsGenerator();

        this.p.getInventory().setItem(0,sigen.getMovePiecesItem());
        this.p.getInventory().setItem(1,sigen.getShopItem());
        this.p.getInventory().setItem(2,sigen.getBuyXPItem());
        this.p.getInventory().setItem(7,sigen.getMoneyItem(this));
        this.p.getInventory().setItem(8,sigen.getHealthItem(this));
        for(int i = 17; i <= 35 ; i++){
            this.p.getInventory().setItem(i,sigen.getLockedItem());
        }
        for(int i = 3; i <= 6 ; i++){
            this.p.getInventory().setItem(i,sigen.getLockedItem());
        }
        this.p.updateInventory();
        this.p.setLevel(this.level);
        this.p.setExp(getLevelPercentage());
    }
}
