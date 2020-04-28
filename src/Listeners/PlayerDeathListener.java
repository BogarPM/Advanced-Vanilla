/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import deathmessages.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author Bogar
 */
public class PlayerDeathListener implements Listener {
    private Main plugin;
    public PlayerDeathListener(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        if(e.getEntity() instanceof Player){
            Player Killer = e.getEntity().getKiller();
            Player p = e.getEntity();
            
            Killer.sendMessage(Utils.Utils.chat("You have killed &7" + p.getDisplayName()));
            p.sendMessage(Utils.Utils.chat("&7You have been killed by &3" + Killer.getDisplayName()));
            return;
        }
    }
}
