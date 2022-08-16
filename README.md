# 🛡 ArmedArmorStands

A simple plugin that adds arms to armor stands upon right click while holding sticks

<img align="center" src="https://i.imgur.com/0WJAOIP.gif">


### Config
```yaml
messages:
  prefix: '&6ArmedArmorstands &8» &7'
  no-permission: '&cYou're not allowed to use this feature!'
permission:
  permission: armorstand.arm # Permission for using the feature
  required: true # If the permission is required in order to use the feature
  send-message: true # If a message should be send if you don't have the permission
settings:
  consume-sticks: true # If the sticks should be removed from the player
  drop-sticks: true # If the 'arms' should drop upon death
```

Developer API (ArmorStandArmEvent)

Methods:
- getPlayer()
- getArmorStand()


```java
import net.kettlemc.armedarmorstands.event.ArmorStandArmEvent;

public class ArmorStandArmListener implements Listener {
 
    @EventHandler
    public void onArmorStandArm(ArmorStandArmEvent event) {
        if (event.getArmorStand().getWorld().getName().contains("farmworld")) {
            event.getPlayer().sendMessage("You are not allowed to use this in the farmworld!");
            event.setCancelled(true);
        }
    }
}
```

### Download

- [SpigotMC](https://www.spigotmc.org/resources/92612)
- [Modrinth](https://modrinth.com/mod/armedarmorstands )
