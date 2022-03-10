package rip.hippo.spigotmenu;

import rip.hippo.spigotmenu.container.MenuContainer;
import rip.hippo.spigotmenu.plugin.SpigotMenuPlugin;

/**
 * @author Hippo
 */
public interface SpigotMenu {
  MenuContainer getMenuContainer();

  static SpigotMenu getAPI() {
    return SpigotMenuPlugin.getApiInstance();
  }
}
