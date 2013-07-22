package com.cin316.minezweapons;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.cin316.minezweapons.KikuichimonjiListener;
import com.cin316.minezweapons.MineZWeapons;

public class MineZWeapons extends JavaPlugin{
	
	public static MineZWeapons plugin;
	public Logger log;
	PluginDescriptionFile pdfFile;
	PluginManager pluginManager;
	public String[] helpText;
	
	public void onEnable(){
		log = Logger.getLogger("Minecraft");
		pdfFile = this.getDescription();
		pluginManager = this.getServer().getPluginManager();
		helpText = new String[]{
			ChatColor.YELLOW + pdfFile.getName() + " version " + pdfFile.getVersion(),
			ChatColor.YELLOW + pdfFile.getDescription()
		};
		
		log.info(pdfFile.getName() + " " + pdfFile.getVersion() + " has been enabled.");
		
		pluginManager.registerEvents( new KikuichimonjiListener(this), this );
	}
	
	public void onDisable(){
		log.info(pdfFile.getName() + " " + " has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		if( commandLabel.equalsIgnoreCase("minezweapons") ){
			
			if( !(sender instanceof Player) ){ //If the console sends the command.
				ConsoleCommandSender console = (ConsoleCommandSender) sender;
				
				console.sendMessage(helpText);
				
			}else{ //If a player sends the command.
				Player player = (Player) sender;
				
				if(player.hasPermission("minezweapons.info")){ //If the player has permission.
					player.sendMessage(helpText);
				}else{ //If the player doesn't has permission.
					
				}
				
			}
			
		}
		
		return true;
	}
	
}