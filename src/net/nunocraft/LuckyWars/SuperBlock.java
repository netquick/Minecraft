package net.nunocraft.LuckyWars;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SuperBlock {
	public static void SuperDrop(Location droppos, Player clicker) {
		Location loc = droppos;
		ItemStack drop = new ItemStack(Material.IRON_SWORD);
		drop.addEnchantment(Enchantment.KNOCKBACK, 2);
		drop.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		loc.getWorld().dropItem(loc, drop);
        //System.out.println(drop.getType().name());

	}
}
