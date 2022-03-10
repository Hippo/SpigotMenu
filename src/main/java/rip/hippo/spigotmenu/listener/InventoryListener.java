package rip.hippo.spigotmenu.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import rip.hippo.spigotmenu.Menu;
import rip.hippo.spigotmenu.SpigotMenu;
import rip.hippo.spigotmenu.component.MenuComponent;
import rip.hippo.spigotmenu.container.MenuContainer;

/**
 * @author Hippo
 */
public final class InventoryListener implements Listener {

  private final MenuContainer menuContainer;

  public InventoryListener(SpigotMenu spigotMenu) {
    this.menuContainer = spigotMenu.getMenuContainer();
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent playerQuitEvent) {
    menuContainer.clear(playerQuitEvent.getPlayer());
  }

  @EventHandler
  public void onPlayerCloseInventory(InventoryCloseEvent inventoryCloseEvent) {
    HumanEntity humanEntity = inventoryCloseEvent.getPlayer();
    if (humanEntity instanceof Player) {
      menuContainer.close((Player) humanEntity);
    }
  }

  @EventHandler
  public void onInventoryDrag(InventoryDragEvent inventoryDragEvent) {
    HumanEntity whoClicked = inventoryDragEvent.getWhoClicked();
    if (whoClicked instanceof Player) {
      Menu menu = menuContainer.getMenu((Player) whoClicked);
      if (menu != null && !menu.isAllowDragging()) {
        inventoryDragEvent.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {
    HumanEntity whoClicked = inventoryClickEvent.getWhoClicked();
    if (!(whoClicked instanceof Player)) {
      return;
    }
    Player player = (Player) whoClicked;
    Menu menu = menuContainer.getMenu(player);
    if (menu == null) {
      return;
    }
    MenuComponent component = menu.getComponent(inventoryClickEvent.getSlot());
    if (component == null) {
      return;
    }
    component.processEvent(player, inventoryClickEvent);
  }
}
