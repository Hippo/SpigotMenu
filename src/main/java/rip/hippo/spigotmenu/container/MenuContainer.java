package rip.hippo.spigotmenu.container;

import org.bukkit.entity.Player;
import rip.hippo.spigotmenu.Menu;
import rip.hippo.spigotmenu.builder.MenuTitleStagedBuilder;

import java.util.List;

/**
 * @author Hippo
 */
public interface MenuContainer {

  MenuTitleStagedBuilder newMenu();
  void register(String name, Menu menu);

  void open(Player player, Menu menu);
  void open(Player player, String menuName);
  void close(Player player);

  Menu getMenu(Player player);
  Menu lookupMenu(String name);

  void clear(Player player);
}
