package com.cin316.minezweapons;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.cin316.minezweapons.MineZWeapons;

public class KikuichimonjiListener implements Listener{
	
	MineZWeapons plugin;
	
	public KikuichimonjiListener(MineZWeapons plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
	    
		
		
	}

}
