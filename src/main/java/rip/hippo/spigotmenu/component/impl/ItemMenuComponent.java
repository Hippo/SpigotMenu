package rip.hippo.spigotmenu.component.impl;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import rip.hippo.spigotmenu.component.MenuComponent;

import java.util.function.Consumer;

/**
 * @author Hippo
 */
public final class ItemMenuComponent implements MenuComponent {

  private final ItemStack itemStack;
  private Consumer<Player> clickAction = ignored -> {};

  public ItemMenuComponent(ItemStack itemStack) {
    this.itemStack = itemStack;
  }

  public ItemMenuComponent then(Consumer<Player> clickAction) {
    this.clickAction = clickAction;
    return this;
  }

  @Override
  public void processEvent(Player player, InventoryClickEvent inventoryClickEvent) {
    inventoryClickEvent.setCancelled(true);
    clickAction.accept(player);
  }

  @Override
  public MenuComponent copy() {
    ItemMenuComponent itemMenuComponent = new ItemMenuComponent(new ItemStack(itemStack));
    itemMenuComponent.clickAction = this.clickAction;
    return itemMenuComponent;
  }

  @Override
  public void accept(Inventory inventory, Integer slot) {
    inventory.setItem(slot, itemStack);
  }

  public Consumer<Player> getClickAction() {
    return clickAction;
  }
}
