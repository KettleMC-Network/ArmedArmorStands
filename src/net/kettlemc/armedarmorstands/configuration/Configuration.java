package net.kettlemc.armedarmorstands.configuration;

import org.bukkit.ChatColor;

public class Configuration {

	private BasicConfigurationHandler config;

	private String prefix, noPermissionMessage, permission;
	private boolean consumeSticks, dropSticks, permissionRequired, sendPermissionMessage;

	public Configuration() {
		this.config = new BasicConfigurationHandler("plugins/ArmedArmorstands/config.yml");
		this.prefix = config.getString("messages.prefix", "&6ArmedArmorstands &8» &7");
		this.noPermissionMessage = config.getString("messages.no-permission", "&cYou're not allowed to use this feature!");
		this.permission = config.getString("permission.permission", "armorstand.arm");
		this.permissionRequired = config.getBool("permission.required", true);
		this.sendPermissionMessage = config.getBool("permission.send-message", true);
		this.consumeSticks = config.getBool("settings.consume-sticks", true);
		this.dropSticks = config.getBool("settings.drop-sticks", true);
	}

	public String getPrefix() {
		return ChatColor.translateAlternateColorCodes('&', prefix);
	}

	public String getNoPermissionMessage() {
		return ChatColor.translateAlternateColorCodes('&', noPermissionMessage);
	}

	public String getPermission() {
		return permission;
	}

	public boolean doConsumeSticks() {
		return consumeSticks;
	}

	public boolean doDropSticks() {
		return dropSticks;
	}

	public boolean isPermissionRequired() {
		return permissionRequired;
	}

	public boolean doSendPermissionMessage() {
		return sendPermissionMessage;
	}

}
