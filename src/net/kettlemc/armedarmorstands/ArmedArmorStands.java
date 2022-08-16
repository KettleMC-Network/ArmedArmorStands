package net.kettlemc.armedarmorstands;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.kettlemc.armedarmorstands.configuration.Configuration;
import net.kettlemc.armedarmorstands.listener.EntityDeathListener;
import net.kettlemc.armedarmorstands.listener.PlayerInteractAtEntityListener;

public class ArmedArmorStands extends JavaPlugin {

	private Configuration configuration;

	public void onEnable() {
		this.configuration = new Configuration();
		Bukkit.getPluginManager().registerEvents(new PlayerInteractAtEntityListener(this), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeathListener(this), this);
	}

	public Configuration getConfiguration() {
		return configuration;
	}

}
