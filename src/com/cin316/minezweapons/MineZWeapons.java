package com.cin316.minezweapons;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MineZWeapons extends JavaPlugin{
	
	public static MineZWeapons plugin;
	public Logger log;
	PluginDescriptionFile pdfFile;
	PluginManager pluginManager;
	public String[] helpText;
	public String[] weapons;
	
	public void onEnable(){
		log = Logger.getLogger("Minecraft");
		pdfFile = this.getDescription();
		pluginManager = this.getServer().getPluginManager();
		helpText = new String[]{
			ChatColor.YELLOW + pdfFile.getName() + " version " + pdfFile.getVersion(),
			ChatColor.YELLOW + pdfFile.getDescription()
		};
		weapons = new String[]{
				ChatColor.YELLOW + "" + "Weapons available:",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Kikuichimonji",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Robber's_Blade",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Simoon's_Deal",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Grass_Blade",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Heal_Bow"
		};
		
		log.info(pdfFile.getName() + " " + pdfFile.getVersion() + " has been enabled.");
		
		pluginManager.registerEvents( new KikuichimonjiListener(this), this );
		pluginManager.registerEvents( new RobbersBladeListener(this), this );
		pluginManager.registerEvents( new SimoonsDealListener(this), this);
		pluginManager.registerEvents( new GrassBladeListener(this), this);
		pluginManager.registerEvents( new GrassBladeListener(this), this);
		pluginManager.registerEvents( new HealBowListener(this), this );
	}
	
	public void onDisable(){
		log.info(pdfFile.getName() + " " + " has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if( !(args.length>=1) ){
			return false;
		}
		
		if( commandLabel.equalsIgnoreCase("minezweapons") ){
			
			if( args[0].equalsIgnoreCase("help") ){
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
			}else if( args[0].equalsIgnoreCase("give") ){
				if( !(sender instanceof Player) ){ //If the console sends the command.
					ConsoleCommandSender console = (ConsoleCommandSender) sender;
					
					console.sendMessage("You must be a player to use this command.");
					
				}else{ //If a player sends the command.
					Player player = (Player) sender;
					
					if( !(args.length>=2) ){
						return false;
					}
					if(player.hasPermission("minezweapons.use")){ //If the player has permission.
						if( args[1].equalsIgnoreCase("kikuichimonji") ){
							
							ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
							ItemMeta im = is.getItemMeta();
							im.setDisplayName(ChatColor.ITALIC + "Kikuichimonji"); //Set its name to Kikuichimonji.
							is.setItemMeta(im);
							player.getInventory().addItem(is);
							
						}else if( args[1].equalsIgnoreCase("robber's_blade") ){
							
							ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
							ItemMeta im = is.getItemMeta();
							im.setDisplayName(ChatColor.ITALIC + "Robber's Blade"); //Set its name to Robber's Blade.
							is.setItemMeta(im);
							player.getInventory().addItem(is);
							
						}else if( args[1].equalsIgnoreCase("simoon's_deal") ){
							
							ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
							ItemMeta im = is.getItemMeta();
							im.setDisplayName(ChatColor.ITALIC + "Simoon's Deal"); //Set its name to Robber's Blade.
							is.setItemMeta(im);
							player.getInventory().addItem(is);
							
						}else if( args[1].equalsIgnoreCase("grass_blade") ){
							
							ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
							ItemMeta im = is.getItemMeta();
							im.setDisplayName(ChatColor.ITALIC + "Grass Blade"); //Set its name to Grass Blade.
							is.setItemMeta(im);
							player.getInventory().addItem(is);
							
						}else if( args[1].equalsIgnoreCase("heal_bow") ){
							
							ItemStack is = new ItemStack(Material.BOW, 1); //Make a stack of 1 Wood Sword
							ItemMeta im = is.getItemMeta();
							im.setDisplayName(ChatColor.ITALIC + "Heal Bow"); //Set its name to Heal Bow.
							is.setItemMeta(im);
							player.getInventory().addItem(is);
							
						}else{
							player.sendMessage(ChatColor.RED + "Invalid weapon.  Type " + ChatColor.ITALIC + "minezweapons list" + ChatColor.RESET + ChatColor.RED + " to get a list of all weapons.");
						}
					}
					
				}
			}else if( args[0].equalsIgnoreCase("list") ){
				if( !(sender instanceof Player) ){ //If the console sends the command.
					ConsoleCommandSender console = (ConsoleCommandSender) sender;
					
					console.sendMessage(weapons);
					
				}else{ //If a player sends the command.
					Player player = (Player) sender;
					
					if(player.hasPermission("minezweapons.info")){ //If the player has permission.
						player.sendMessage(weapons);
					}
					
				}
			}
			
		}
		
		return true;
	}
	
}