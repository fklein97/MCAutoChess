package main.Interface;

import main.MCAutoChess;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpecialItemsGenerator {

    private MCAutoChess plugin;

    public ItemStack getMoneyItem(int amount) {
        ItemStack money = new ItemStack(Material.DIAMOND,amount);
        ItemMeta money_meta = money.getItemMeta();
        money_meta.setDisplayName("Money");
        money.setItemMeta(money_meta);

        return money;
    }
}
