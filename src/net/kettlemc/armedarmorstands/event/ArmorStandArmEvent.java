package net.kettlemc.armedarmorstands.event;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArmorStandArmEvent extends Event implements Cancellable {

	private final static HandlerList handlers = new HandlerList();
	private boolean isCancelled;

	private ArmorStand armorStand;
	private Player player;

	public ArmorStandArmEvent(Player player, ArmorStand armorStand) {
		this.player = player;
		this.armorStand = armorStand;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.isCancelled = cancel;
	}

	public ArmorStand getArmorStand() {
		return armorStand;
	}

	public Player getPlayer() {
		return player;
	}

}
