package net.nunocraft.LuckyWars;

import org.bukkit.plugin.java.JavaPlugin;

public class LuckyWars extends JavaPlugin {
	@Override
    public void onEnable() {
	    getServer().getPluginManager().registerEvents(new Listeners(this), this);
		loadConfiguration();
		
	    this.getCommand("lw").setExecutor(new CE_LuckyWars(this));

    }
    @Override
    public void onDisable() {
        System.out.println("LuckyWars unloaded!");
    }
	public void loadConfiguration() {
		this.getConfig().addDefault("BreakOnArrow", false);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
}
