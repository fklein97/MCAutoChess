package main.Listeners;

import main.MCAutoChess;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldListener implements Listener {
    private MCAutoChess plugin;

    public WorldListener(MCAutoChess plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event){
        if(event.toWeatherState()){
            event.setCancelled(true);
        }
    }
}
