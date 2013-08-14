package com.cin316.minezweapons;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Effect.Type;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class GrassBladeListener implements Listener {
	
	MineZWeapons plugin;
	
	public GrassBladeListener(MineZWeapons plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
	    
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (entity instanceof Player){
			
			//Create the variable for the player (getting hit)
			Player hurted = (Player)entity;
			//Check if the event is a Entity damage event (basically)
			if (event instanceof EntityDamageByEntityEvent){
				
				//Get a variable for the cause of the damage
				EntityDamageByEntityEvent damageCause = (EntityDamageByEntityEvent)event;
				//Check if the damager is a player
				if (damageCause.getDamager() instanceof Player){
					
					//Get the variable for the player who punched someone
					Player hitter = (Player)damageCause.getDamager();
					
					//Check if the hitter is holding a Grass Blade and it is a wood sword.
					if( hitter.getItemInHand().getType().equals(Material.WOOD_SWORD) ){
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Grass Blade") ){
								
								//Do stuff.
								//hurted.getWorld().playEffect(hurted.getLocation(), new Effect(2001, Type.SOUND, Material.GRASS.class), 2003);
								
							
							}
						}
					}
					
				}
				
			}
			
		}
		
		
	}
	
}
