package rip.hippo.spigotmenu.component;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.function.BiConsumer;


/**
 * @author Hippo
 */
public interface MenuComponent extends BiConsumer<Inventory, Integer> {
  void processEvent(Player player, InventoryClickEvent inventoryClickEvent);
  MenuComponent copy();
}
