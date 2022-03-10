package rip.hippo.spigotmenu.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import rip.hippo.spigotmenu.SpigotMenu;
import rip.hippo.spigotmenu.container.MenuContainer;
import rip.hippo.spigotmenu.container.impl.StandardMenuContainer;
import rip.hippo.spigotmenu.listener.InventoryListener;

/**
 * @author Hippo
 */
public final class SpigotMenuPlugin extends JavaPlugin implements SpigotMenu {

  private final MenuContainer menuContainer = new StandardMenuContainer();

  private static SpigotMenu apiInstance;

  @Override
  public void onEnable() {
    apiInstance = this;
    Bukkit.getPluginManager().registerEvents(new InventoryListener(this), this);
  }

  @Override
  public MenuContainer getMenuContainer() {
    return menuContainer;
  }

  public static SpigotMenu getApiInstance() {
    return apiInstance;
  }
}
