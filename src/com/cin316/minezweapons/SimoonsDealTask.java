package com.cin316.minezweapons;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SimoonsDealTask extends BukkitRunnable {
	
	MineZWeapons plugin;
	Player player;
	
	public SimoonsDealTask(MineZWeapons plugin, Player player) {
		this.plugin = plugin;
		this.player = player;
	}
	
	public void run() {
		
		//Strikes the player with lightning.
		player.getWorld().strikeLightning(player.getLocation());
		//Gives the hitter Nausea I for 60 seconds.
		player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 1) );
		//Gives the hitter Weakness I for 60 seconds.
		player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 1) );
		//Gives the hitter Slowness I for 60 seconds.
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 1) );
		
	}

}
