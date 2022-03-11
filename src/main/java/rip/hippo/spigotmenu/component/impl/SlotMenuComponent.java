package rip.hippo.spigotmenu.component.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import rip.hippo.spigotmenu.component.MenuComponent;

/**
 * @author Hippo
 */
public final class SlotMenuComponent implements MenuComponent {

  public SlotFunction slotFunction;

  public SlotMenuComponent(SlotFunction slotFunction) {
    this.slotFunction = slotFunction;
  }

  @Override
  public void processEvent(Player player, InventoryClickEvent inventoryClickEvent) {
    int slot = inventoryClickEvent.getSlot();
    Inventory inventory = inventoryClickEvent.getInventory();
    ItemStack cursor = inventoryClickEvent.getCursor();
    ItemStack old = inventory.getItem(slot);

    if (old == null && cursor == null) {
      return;
    }

    boolean cancel = slotFunction.accept(player, old, cursor);

    if (cancel) {
      inventoryClickEvent.setCancelled(true);
    }
  }

  @Override
  public MenuComponent copy() {
    return new SlotMenuComponent(slotFunction);
  }

  @Override
  public void accept(Inventory inventory, Integer slots) {}


  public interface SlotFunction {
    /**
     * Processes slot functions.
     *
     * @param player the player.
     * @param oldItem the old item.
     * @param newItem the new item.
     * @return  If the inventory event should be cancelled.
     */
    boolean accept(Player player, ItemStack oldItem, ItemStack newItem);
  }
}
