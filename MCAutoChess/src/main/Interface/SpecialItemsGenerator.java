package main.Interface;

import main.MCAutoChess;
import main.Mode.ChessPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class SpecialItemsGenerator {

    private MCAutoChess plugin;

    public ItemStack getMoneyItem(ChessPlayer cp) {
        ItemStack money;
        if(cp.getMoney() > 0) {
            money = new ItemStack(Material.GOLD_INGOT, cp.getMoney());
        }
        else{
            money = new ItemStack(Material.GOLD_INGOT, 1);
        }
        ItemMeta money_meta = money.getItemMeta();
        money_meta.setDisplayName(ChatColor.GOLD + "Money (" + cp.getMoney() + ")");
        ArrayList<String> money_discription = new ArrayList<String>();
        money_discription.add("use this to buy chesspieces or level up!");
        money_meta.setLore(money_discription);
        money.setItemMeta(money_meta);

        return money;
    }

    public ItemStack getHealthItem(ChessPlayer cp) {
        ItemStack health = new ItemStack(Material.PLAYER_HEAD,cp.getHealth());
        SkullMeta health_meta = (SkullMeta) health.getItemMeta();
        health_meta.setDisplayName(ChatColor.RED + "Health (" + cp.getHealth() + ")");
        health_meta.setOwningPlayer(Bukkit.getOfflinePlayer(cp.getPlayer().getUniqueId()));
        health.setItemMeta(health_meta);

        return health;
    }

    public ItemStack getLockedItem(){
        ItemStack locked = new ItemStack(Material.IRON_BARS,1);
        ItemMeta locked_meta = locked.getItemMeta();
        locked_meta.setDisplayName(ChatColor.DARK_GRAY + "Itemslot locked!");
        locked.setItemMeta(locked_meta);
        return locked;
    }

    public ItemStack getShopItem(){
        ItemStack shop = new ItemStack(Material.CHEST, 1);
        ItemMeta shop_meta = shop.getItemMeta();
        shop_meta.setDisplayName(ChatColor.AQUA + "[Right Click] Open Shop");
        shop.setItemMeta(shop_meta);
        return shop;
    }

    public ItemStack getBuyXPItem(){
        ItemStack buyXP = new ItemStack(Material.EXPERIENCE_BOTTLE, 4);
        ItemMeta buyXP_meta = buyXP.getItemMeta();
        buyXP_meta.setDisplayName(ChatColor.AQUA + "[Right Click] Buy 4XP for 5Gold");
        buyXP.setItemMeta(buyXP_meta);
        return buyXP;
    }

    public ItemStack getMovePiecesItem(){
        ItemStack movePieces = (new ItemStack(Material.MAP,1));
        ItemMeta movePieces_meta = movePieces.getItemMeta();
        movePieces_meta.setDisplayName(ChatColor.AQUA + "[Right Click] Move your Chess Pieces");
        movePieces.setItemMeta(movePieces_meta);
        return movePieces;
    }
}
