package net.kettlemc.armedarmorstands.listener;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import net.kettlemc.armedarmorstands.ArmedArmorStands;
import net.kettlemc.armedarmorstands.configuration.Configuration;

public class EntityDeathListener implements Listener {

	private Configuration config;

	public EntityDeathListener(ArmedArmorStands plugin) {
		this.config = plugin.getConfiguration();
	}

	@EventHandler
	public void onEntityInteract(EntityDeathEvent event) {

		if (event.getEntityType() != EntityType.ARMOR_STAND)
			return;
		
		ArmorStand armorStand = (ArmorStand) event.getEntity();

		if (armorStand.hasArms() && config.doDropSticks()) {
			ItemStack sticks = new ItemStack(Material.STICK);
			sticks.setAmount(2);
			armorStand.getWorld().dropItem(armorStand.getLocation(), sticks);
		}
	}

}
