package net.nunocraft.LuckyWars;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

public class Listeners implements Listener {
	private LuckyWars plugin;
	public Listeners(LuckyWars plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void OnBreak(BlockBreakEvent event) {
		Player clicker = event.getPlayer();
		Block broken = event.getBlock();
		Location droppos = event.getBlock().getLocation();
		if(broken == null || broken.getType().equals(Material.AIR)){ }
		if(broken.getType().equals(Material.SPONGE)) {
			//clicker.sendMessage("Player " + clicker.getName() + " broke a LuckyBlock");
	        event.setCancelled(true);
	        broken.setType(Material.AIR);
	        randomBlock(droppos, clicker);
		}
	}
	//Optional Drop on Interact with block
	@EventHandler
	public void OnHit(PlayerInteractEvent event) {
		Player clicker = event.getPlayer();
		Boolean enablebreak = plugin.getConfig().getBoolean("BreakBlockOnInteract");
		if(enablebreak == true) {
			
			if(event.getClickedBlock().getType()==Material.SPONGE) {
				event.getClickedBlock().setType(Material.AIR);
				Location droppos = event.getClickedBlock().getLocation();
				randomBlock(droppos, clicker);
			}
		}
		if(enablebreak == false) {
			
		}		
	}
	@EventHandler
	public void OnShoot(ProjectileHitEvent event) {
		Entity entity = event.getEntity();
		Player clicker = (Player) event.getEntity().getShooter();
		Boolean enablearrow = plugin.getConfig().getBoolean("BreakOnArrow");

		if(enablearrow == true) {
			if(entity instanceof Arrow);
			{
				BlockIterator iterator = new BlockIterator(entity.getWorld(),entity.getLocation().toVector(), entity.getVelocity().normalize(), 0, 4);
				Block hitBlock = null;
				while(iterator.hasNext()) {
					hitBlock = iterator.next();
					if(hitBlock.getType()!=Material.AIR) {
						break;
					}
				}
				if(hitBlock.getType() == Material.SPONGE) {
					hitBlock.setType(Material.AIR);
					entity.remove();
					Location droppos = hitBlock.getLocation();
					randomBlock(droppos, clicker);

				}
			}
		}


	}
	public void randomBlock (Location droppos, Player clicker) {
		Random r = new Random();
		int zufall = r.nextInt(25);
		//DEBUG System.out.println(zufall);
		switch(zufall) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4: UnLuckyBlock.UnLuckyDrop(droppos, clicker);
				break;
		case 5: SuperBlock.SuperDrop(droppos, clicker);
				break;
		default: LuckyBlock.LuckyDrop(droppos, clicker);
		
		
		}
	}

}
