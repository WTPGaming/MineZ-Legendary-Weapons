package com.cin316.minezweapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MjolnirListener implements Listener {
	
	MineZWeapons plugin;
	
	public MjolnirListener(MineZWeapons plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player hitter = event.getPlayer();
		
		//Check if event is caused by right click.
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			//Check if the hitter is holding a Mjolnir and it is a wood sword.
			if( hitter.getItemInHand().getType().equals(Material.IRON_AXE) ){
				if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Mjolnir") ){
						
						//Do stuff.
						
						//Destroys Mjolnir.
						hitter.setItemInHand(null);
						
						//Update hitter's inventory.
						hitter.updateInventory();
						
						//Strike lightning where player is looking.
						hitter.getWorld().strikeLightning( hitter.getTargetBlock(null, 100).getLocation() );
						
						//Damage the Mjolnir.
						hitter.getItemInHand().setDurability( (short) (hitter.getItemInHand().getDurability()+1) );
						
					}
				}
			}
		}
		
	}
	
}
