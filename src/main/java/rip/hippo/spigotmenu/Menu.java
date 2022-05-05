package rip.hippo.spigotmenu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import rip.hippo.spigotmenu.component.MenuComponent;

/**
 * @author Hippo
 */
public class Menu {

  private final String title;
  private final int rows;
  private final boolean allowDragging;
  private final MenuComponent[] menuComponents;

  private Inventory inventory;

  public Menu(String title, int rows, boolean allowDragging, MenuComponent[] menuComponents) {
    this.title = title;
    this.rows = rows;
    this.allowDragging = allowDragging;
    this.menuComponents = menuComponents;
  }

  public Inventory getInventory() {
    if (inventory == null) {
      inventory = Bukkit.createInventory(null, rows * 9, title);
      for (int i = 0; i < menuComponents.length; i++) {
        MenuComponent menuComponent = menuComponents[i];
        if (menuComponent != null) {
          menuComponent.accept(inventory, i);
        }
      }
    }
    return inventory;
  }

  public boolean hasComponent(int slot) {
    return slot >= 0 && slot < menuComponents.length && menuComponents[slot] != null;
  }

  public MenuComponent getComponent(int slot) {
    if (!hasComponent(slot)) {
      return null;
    }
    return menuComponents[slot];
  }

  public String getTitle() {
    return title;
  }

  public int getRows() {
    return rows;
  }

  public boolean isAllowDragging() {
    return allowDragging;
  }
}
