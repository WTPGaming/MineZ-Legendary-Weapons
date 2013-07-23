package com.cin316.minezweapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SimoonsDealListener implements Listener {
	
	MineZWeapons plugin;
	
	public SimoonsDealListener(MineZWeapons plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player hitter = event.getPlayer();
		
		//Check if event is caused by right click.
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			//Check if the hitter is holding a Simoon's Deal and it is a wood sword.
			if( hitter.getItemInHand().getType().equals(Material.WOOD_SWORD) ){
				if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Simoon's Deal") ){
						
						//Do stuff.
						
						//Destroys Simoon's Deal.
						hitter.setItemInHand(null);
						
						//Gives the hitter Speed II for 60 seconds.
						hitter.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1) );
						//Gives the hitter Strength I for 60 seconds.
						hitter.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0) );
						
						//Schedules SimoonsDealTask to be run in 60 seconds.
						//new SimoonsDealTask(plugin, hitter).runTaskLater(plugin, 1200);
						
					}
				}
			}
		}
		
	}
	
}
