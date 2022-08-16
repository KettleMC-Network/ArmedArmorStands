package net.kettlemc.armedarmorstands.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

import net.kettlemc.armedarmorstands.ArmedArmorStands;
import net.kettlemc.armedarmorstands.configuration.Configuration;
import net.kettlemc.armedarmorstands.event.ArmorStandArmEvent;

public class PlayerInteractAtEntityListener implements Listener {

	private Configuration config;

	public PlayerInteractAtEntityListener(ArmedArmorStands plugin) {
		this.config = plugin.getConfiguration();
	}

	@EventHandler
	public void onEntityInteract(PlayerInteractAtEntityEvent event) {
		
		// Check if event is cancelled by another plugin
		if (event.isCancelled())
			return;

		// Check if the entity is an ArmorStand
		if (event.getRightClicked().getType() != EntityType.ARMOR_STAND)
			return;

		Player player = event.getPlayer();

		ItemStack currentItem = player.getInventory().getItemInMainHand();

		// Check if the player's item is a stick (using name for mod compatibility)
		if (!currentItem.getType().name().toLowerCase().contains("stick"))
			return;

		// Check if the amount of sticks is at least 2 (only if they will be consumed)
		if (currentItem.getAmount() < 2 && config.doConsumeSticks())
			return;

		ArmorStand armorStand = (ArmorStand) event.getRightClicked();

		// Check if the ArmorStand already has arms, is invisible or invulnerable
		if (armorStand.hasArms() || !armorStand.isVisible() || armorStand.isInvulnerable())
			return;

		// Creating an event and checking if it's cancelled
		ArmorStandArmEvent armorStandArmEvent = new ArmorStandArmEvent(player, armorStand);
		Bukkit.getPluginManager().callEvent(armorStandArmEvent);
		if (armorStandArmEvent.isCancelled())
			return;
		
		// Check if the permission is needed, if the player has it and if a message should be sent
		if (config.isPermissionRequired() && !player.hasPermission(config.getPermission())) {
			if (config.doSendPermissionMessage())
				player.sendMessage(config.getPrefix() + config.getNoPermissionMessage());
			return;
		}

		event.setCancelled(true);
		
		armorStand.setArms(true);

		// Remove 2 sticks (only if enabled in config and if player isn't in CREATIVE)
		if (config.doConsumeSticks() && player.getGameMode() != GameMode.CREATIVE)
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 2);

	}

}
