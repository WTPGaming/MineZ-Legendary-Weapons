package com.cin316.minezweapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HealBowListener implements Listener {
	
	MineZWeapons plugin;
	
	public HealBowListener(MineZWeapons plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamangeByEntity(EntityDamageByEntityEvent event){
		
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (entity instanceof Player){
			
			//Create the variable for the player (getting hit)
			Player hurted = (Player)entity;
			//Check if the event is a Entity damage event (basically)
			if (event instanceof EntityDamageByEntityEvent){
				
				//Get a variable for the cause of the damage
				EntityDamageByEntityEvent damageCause = (EntityDamageByEntityEvent)event;
				//Check if the damager is an arrow.
				if (damageCause.getDamager() instanceof Arrow){
					
					//Get the variable for the player who punched someone
					Player hitter = (Player)((Arrow)event.getDamager()).getShooter();
					
					//Check if the hitter is holding a Grass Blade and it is a wood sword.
					if( hitter.getItemInHand().getType().equals(Material.BOW) ){
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Heal Bow") ){
								
								//Do stuff.
								event.setCancelled(true);
								hurted.setHealth( hurted.getHealth()+3 );
								
							
							}
						}
					}
					
				}
				
			}
			
		}
		
	}
	
}
