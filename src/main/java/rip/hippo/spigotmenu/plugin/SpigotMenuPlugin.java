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

  private final MenuContainer menuContainer;

  private static SpigotMenu apiInstance;

  public SpigotMenuPlugin() {
    apiInstance = this;
    this.menuContainer = new StandardMenuContainer();
  }

  @Override
  public void onEnable() {
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
