package net.nunocraft.LuckyWars;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class LuckyBlock {
	public static void LuckyDrop (Location droppos, Player clicker) {
		Location loc = droppos;
		ItemStack drop = null;
		int category = Randomize.getRandom(4);
		int itemno;
		int enchantcount = Randomize.getRandom(3);
        System.out.println("Cat: " + category);
        switch(category) {
        case 0: itemno = Randomize.getRandom(10);
        		drop = getWeaponDrop(itemno, drop);
        		int enchant = 0;
        		for(int i=0; i<enchantcount; i++ ) {
        			switch(itemno) {
        			case 0: enchant = Randomize.getRandom(8);
        			break;
        			case 1: enchant = Randomize.getRandom(5);
        			break;
        			case 2: enchant = Randomize.getRandom(8);
        			break;
        			case 3: enchant = Randomize.getRandom(5);
        			break;
        			case 4: enchant = Randomize.getRandom(8);
        			break;
        			case 5: enchant = Randomize.getRandom(5);
        			break;
        			case 6: enchant = Randomize.getRandom(8);
        			break;
        			case 7: enchant = Randomize.getRandom(5);
        			break;
        			case 9: enchant = Randomize.getRandom(8);
        			break;
        			case 10: enchant = Randomize.getRandom(5);
        			break;
        			}
        			getWeaponEnchant(enchant, drop);
        		}
        break;
        case 1: itemno = Randomize.getRandom(16);
        		drop = getArmorDrop(itemno, drop);
        		//DEBUG System.out.println("Itemno: " + itemno);
        		for(int i=0; i<enchantcount; i++) {
        			getArmorEnchant(drop, itemno);
        		}
        break;
        case 2: itemno = Randomize.getRandom(8);
        		//System.out.println("DEBUG getFoodDrop: Itemno: " + itemno);
        		drop = getFoodDrop(itemno, drop);
        break;
        case 3: itemno = Randomize.getRandom(10);
        		drop = getItemDrop(itemno, drop);
        break;
        case 4: itemno = Randomize.getRandom(10);
        drop = getMobSpawn(itemno, drop);
        break;
        case 5: itemno = Randomize.getRandom(10);
        drop = getBuilding(itemno, drop);
        break;
        case 6: itemno = Randomize.getRandom(10);
        drop = getEffect(itemno, drop);
        break;
        case 7: itemno = Randomize.getRandom(10);
        drop = getPotion(itemno, drop);
        break;
        
        }		
        if(drop == null) {
        	
        }
		loc.getWorld().dropItem(loc, drop);
	}

	private static ItemStack getPotion(int itemno, ItemStack drop) {
		return drop;
		// TODO Auto-generated method stub
		
	}

	private static ItemStack getFoodDrop(int itemno, ItemStack drop) {
		//System.out.println("DEBUG getFoodDrop: Itemno: " + itemno);

		switch(itemno) {
		case 0:		drop = new ItemStack(Material.APPLE);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 1: 	drop = new ItemStack(Material.BREAD);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 2:		drop = new ItemStack(Material.MUSHROOM_SOUP);
					drop.setAmount(1);
					break;
		case 3: 	drop = new ItemStack(Material.COOKED_BEEF);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 4:		drop = new ItemStack(Material.COOKED_CHICKEN);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 5: 	drop = new ItemStack(Material.COOKED_FISH);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 6:		drop = new ItemStack(Material.COOKED_MUTTON);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 7: 	drop = new ItemStack(Material.BEETROOT_SOUP);
					drop.setAmount(1);
					break;
		}
		
		return drop;
	}

	private static ItemStack getItemDrop(int itemno, ItemStack drop) {
		System.out.println("DEBUG getItemDrop: Itemno: " + itemno);
		EnchantmentStorageMeta meta = (EnchantmentStorageMeta) drop.getItemMeta();
		switch (itemno) {
		case 0:		drop = new ItemStack(Material.ENDER_PEARL);
					drop.setAmount(Randomize.getRandom(4)+1);
					break;
		case 1:		drop = new ItemStack(Material.WEB);
					drop.setAmount(Randomize.getRandom(8)+1);
					break;
		case 2: 	drop = new ItemStack(Material.FLINT_AND_STEEL);
					drop.setAmount(1);
					break;
		case 3:		drop = new ItemStack(Material.COMPASS);
					drop.setAmount(1);
					break;
		case 4:		drop = new ItemStack(Material.MILK_BUCKET);
					drop.setAmount(1);
					break;
		case 5:		drop = new ItemStack(Material.BONE);
					drop.setAmount(Randomize.getRandom(16)+1);
					break;
		case 6:		drop = new ItemStack(Material.IRON_BARDING);
					drop.setAmount(1);
					break;
		case 7:		drop = new ItemStack(Material.ENCHANTED_BOOK);
					meta = (EnchantmentStorageMeta) drop.getItemMeta();
					meta.addStoredEnchant(Enchantment.DAMAGE_ALL, Randomize.getRandom(5)+1, true);
					break;
		case 8:		drop = new ItemStack(Material.ENCHANTED_BOOK);
					meta = (EnchantmentStorageMeta) drop.getItemMeta();
					meta.addStoredEnchant(Enchantment.KNOCKBACK, Randomize.getRandom(2)+1, true);
					break;
		case 9: 	drop = new ItemStack(Material.TNT);
					drop.setAmount(Randomize.getRandom(16));
					break;
		}
		drop.setItemMeta(meta);
		return drop;
	}

	private static ItemStack getMobSpawn(int itemno, ItemStack drop) {
		return drop;
		// TODO Auto-generated method stub
		
	}

	private static ItemStack getBuilding(int itemno, ItemStack drop) {
		return drop;
		// TODO Auto-generated method stub
		
	}

	private static ItemStack getEffect(int itemno, ItemStack drop) {

		return drop;
		// TODO Auto-generated method stub
		
	}

	private static ItemStack getArmorEnchant(ItemStack drop, int itemno) {
		int enchant;
		switch(itemno) {
		
		case 0:	enchant = Randomize.getRandom(9);
				getBootEnchant (enchant, drop);
		break;
		case 1: enchant = Randomize.getRandom(7);
				getChestEnchant (enchant, drop);
		break;
		case 2: enchant = Randomize.getRandom(8);
				getHelmetEnchant (enchant, drop);
		break;
		case 3: enchant = Randomize.getRandom(6);
				getLeggingsEnchant (enchant, drop);
		break;		
		}
		return drop;
	}
	public static ItemStack getBootEnchant(int enchant, ItemStack drop) {
		switch (enchant) {
		case 0: drop.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Randomize.getRandom(4)+1);
		break;
		case 1: drop.addEnchantment(Enchantment.PROTECTION_FIRE, Randomize.getRandom(4)+1);
		break;
		case 2: drop.addEnchantment(Enchantment.PROTECTION_FALL, Randomize.getRandom(4)+1);
		break;
		case 3: drop.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Randomize.getRandom(4)+1);
		break;
		case 4: drop.addEnchantment(Enchantment.PROTECTION_PROJECTILE, Randomize.getRandom(4)+1);
		break;
		case 5: drop.addEnchantment(Enchantment.DEPTH_STRIDER, Randomize.getRandom(3)+1);
		break;
		case 6: drop.addEnchantment(Enchantment.FROST_WALKER, Randomize.getRandom(2)+1);
		break;
		case 7: drop.addEnchantment(Enchantment.DURABILITY, Randomize.getRandom(3)+1);
		break;
		case 8: drop.addEnchantment(Enchantment.MENDING, 1);
		}
		return drop;	
	}
	public static ItemStack getChestEnchant(int enchant, ItemStack drop) {
		switch (enchant) {
		case 0: drop.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Randomize.getRandom(4)+1);
		break;
		case 1: drop.addEnchantment(Enchantment.PROTECTION_FIRE, Randomize.getRandom(4)+1);
		break;
		case 2: drop.addEnchantment(Enchantment.THORNS, Randomize.getRandom(3)+1);
		break;
		case 3: drop.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Randomize.getRandom(4)+1);
		break;
		case 4: drop.addEnchantment(Enchantment.PROTECTION_PROJECTILE, Randomize.getRandom(4)+1);
		break;
		case 5: drop.addEnchantment(Enchantment.DURABILITY, Randomize.getRandom(3)+1);
		break;
		case 6: drop.addEnchantment(Enchantment.MENDING, 1);
		break;
		}
		return drop;	
	}
	public static ItemStack getHelmetEnchant(int enchant, ItemStack drop) {
		switch (enchant) {
		case 0: drop.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Randomize.getRandom(4)+1);
		break;
		case 1: drop.addEnchantment(Enchantment.PROTECTION_FIRE, Randomize.getRandom(4)+1);
		break;
		case 2: drop.addEnchantment(Enchantment.OXYGEN, Randomize.getRandom(3)+1);
		break;
		case 3: drop.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Randomize.getRandom(4)+1);
		break;
		case 4: drop.addEnchantment(Enchantment.PROTECTION_PROJECTILE, Randomize.getRandom(4)+1);
		break;
		case 5: drop.addEnchantment(Enchantment.DURABILITY, Randomize.getRandom(3)+1);
		break;
		case 6: drop.addEnchantment(Enchantment.MENDING, 1);
		break;
		case 7: drop.addEnchantment(Enchantment.WATER_WORKER, 1);
		break;
		}
		
		return drop;	
	}
	public static ItemStack getLeggingsEnchant(int enchant, ItemStack drop) {
		switch (enchant) {
		case 0: drop.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Randomize.getRandom(4)+1);
		break;
		case 1: drop.addEnchantment(Enchantment.PROTECTION_FIRE, Randomize.getRandom(4)+1);
		break;
		case 2: drop.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, Randomize.getRandom(4)+1);
		break;
		case 3: drop.addEnchantment(Enchantment.PROTECTION_PROJECTILE, Randomize.getRandom(4)+1);
		break;
		case 4: drop.addEnchantment(Enchantment.DURABILITY, Randomize.getRandom(3)+1);
		break;
		case 5: drop.addEnchantment(Enchantment.MENDING, 1);
		break;
		}
		return drop;	
	}
	
	private static ItemStack getWeaponEnchant(int enchant, ItemStack drop) {
		//System.out.println("DEBUG WeaponEnchant: Enchant: " + enchant);
		switch(enchant) {
		case 0:	drop.addEnchantment(Enchantment.DAMAGE_ALL, Randomize.getRandom(5)+1);
		break;
		case 1: drop.addEnchantment(Enchantment.DURABILITY, Randomize.getRandom(3)+1);
		break;
		case 2: drop.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, Randomize.getRandom(5)+1);
		break;
		case 3: drop.addEnchantment(Enchantment.DAMAGE_UNDEAD, Randomize.getRandom(5)+1);
		break;
		case 4: drop.addEnchantment(Enchantment.MENDING, 1);
		break;
		case 5: drop.addEnchantment(Enchantment.FIRE_ASPECT, Randomize.getRandom(2)+1);
		break;
		case 6: drop.addEnchantment(Enchantment.LOOT_BONUS_MOBS, Randomize.getRandom(3)+1);
		break;
		case 7: drop.addEnchantment(Enchantment.KNOCKBACK, Randomize.getRandom(2)+1);
		break;
		}
		return drop;
	}

	private static ItemStack getArmorDrop(int itemno, ItemStack drop) {
		switch(itemno) {
		case 0:		drop = new ItemStack(Material.LEATHER_BOOTS);
		break;
		case 1:		drop = new ItemStack(Material.LEATHER_CHESTPLATE);
		break;
		case 2:		drop = new ItemStack(Material.LEATHER_HELMET);
		break;
		case 3:		drop = new ItemStack(Material.LEATHER_LEGGINGS);
		break;
		case 4:		drop = new ItemStack(Material.IRON_BOOTS);
		break;
		case 5:		drop = new ItemStack(Material.IRON_CHESTPLATE);
		break;
		case 6:		drop = new ItemStack(Material.IRON_HELMET);
		break;
		case 7:		drop = new ItemStack(Material.IRON_LEGGINGS);
		break;
		case 8:		drop = new ItemStack(Material.CHAINMAIL_BOOTS);
		break;
		case 9:		drop = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		break;
		case 10:		drop = new ItemStack(Material.CHAINMAIL_HELMET);
		break;
		case 11:		drop = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		break;
		case 12:		drop = new ItemStack(Material.GOLD_BOOTS);
		break;
		case 13:		drop = new ItemStack(Material.GOLD_CHESTPLATE);
		break;
		case 14:		drop = new ItemStack(Material.GOLD_HELMET);
		break;
		case 15:		drop = new ItemStack(Material.GOLD_LEGGINGS);
		break;
		}
		
		return drop;
	}

	private static ItemStack getWeaponDrop(int itemno, ItemStack drop) {
		switch(itemno) {
		case 0: 	drop = new ItemStack(Material.WOOD_SWORD);
		break;
		case 1:		drop = new ItemStack(Material.WOOD_AXE);
		break;
		case 2:		drop = new ItemStack(Material.STONE_SWORD);
		break;
		case 3:		drop = new ItemStack(Material.STONE_AXE);
		break;
		case 4:		drop = new ItemStack(Material.IRON_SWORD);
		break;
		case 5:		drop = new ItemStack(Material.IRON_AXE);
		break;
		case 6:		drop = new ItemStack(Material.GOLD_SWORD);
		break;
		case 7:		drop = new ItemStack(Material.GOLD_AXE);
		break;
		case 8:		drop = new ItemStack(Material.DIAMOND_SWORD);
		break;
		case 9:		drop = new ItemStack(Material.DIAMOND_AXE);				
		}
		return drop;
	}


}