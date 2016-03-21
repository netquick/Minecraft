package net.nunocraft.LuckyWars;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CE_LuckyWars implements CommandExecutor  {
	//private LuckyWars plugin;
	public CE_LuckyWars (LuckyWars t) {
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {     
        if (cmd.getName().equalsIgnoreCase("lw")) {
        	Player player = (Player) sender;
        	if (args.length>2) {
                return false; 
            }
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    System.out.println("Command must be used as player");
                    return true;
                }
                
                player.sendMessage(ChatColor.GREEN + "LuckyWars");
                player.sendMessage(ChatColor.GREEN + "=========");
                player.sendMessage(ChatColor.GREEN + "/lw arrow on/off - Block destruction on Arrow Hit");
                return true;
            }
            if (args.length==1) {
    			player.sendMessage(ChatColor.RED + "Missing Value");

            }
            if (args.length==2) {
            	if (args[0].equalsIgnoreCase("arrow")) {
            		if (args[1].equalsIgnoreCase("on")) { 
            			
            			//plugin.getConfig().set("BreakOnArrow", true);
            			
            			// TODO NullException find
            			player.sendMessage(ChatColor.GREEN + "LuckyWars Arrows ON");
            			//plugin.saveConfig();
            		}
            		if (args[1].equalsIgnoreCase("off")) {
            			player.sendMessage(ChatColor.GREEN + "LuckyWars Arrows are OFF");
            			// TODO NullException find

            			//plugin.getConfig().set("BreakOnArrow", false);
            			//plugin.saveConfig();
            		}
            	}
            }
        }
        return false;
    }
}
