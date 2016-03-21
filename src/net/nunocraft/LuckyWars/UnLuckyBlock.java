package net.nunocraft.LuckyWars;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class UnLuckyBlock {
	public static void UnLuckyDrop(Location droppos, Player clicker) {
		droppos.getWorld().spawnEntity(droppos,  EntityType.PRIMED_TNT);
		clicker.getPlayer().playSound(clicker.getLocation(), Sound.ENTITY_ENDERMEN_SCREAM, 10, 1);



	}
}
