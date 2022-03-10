package rip.hippo.spigotmenu.container.impl;

import org.bukkit.entity.Player;
import rip.hippo.spigotmenu.Menu;
import rip.hippo.spigotmenu.builder.MenuTitleStagedBuilder;
import rip.hippo.spigotmenu.container.MenuContainer;

import java.util.*;

/**
 * @author Hippo
 */
public final class StandardMenuContainer implements MenuContainer {

  private final Map<String, Menu> menuLookup = new HashMap<>();
  private final Map<UUID, Stack<Menu>> menuStackMap = new HashMap<>();

  @Override
  public MenuTitleStagedBuilder newMenu() {
    return new MenuTitleStagedBuilder(this);
  }

  @Override
  public void register(String name, Menu menu) {
    menuLookup.put(name, menu);
  }

  @Override
  public void open(Player player, Menu menu) {
    menuStackMap.computeIfAbsent(player.getUniqueId(), ignored -> new Stack<>()).push(menu);
    player.openInventory(menu.getInventory());
  }

  @Override
  public void open(Player player, String menuName) {
    Menu menu = lookupMenu(menuName);
    if (menu != null) {
      open(player, menu);
    }
  }

  @Override
  public void close(Player player) {
    Stack<Menu> menus = menuStackMap.get(player.getUniqueId());
    if (menus != null && !menus.isEmpty()) {
      menus.pop();
    }
  }

  @Override
  public Menu getMenu(Player player) {
    Stack<Menu> menus = menuStackMap.get(player.getUniqueId());
    if (menus != null && !menus.isEmpty()) {
      return menus.peek();
    }
    return null;
  }

  @Override
  public Menu lookupMenu(String name) {
    return menuLookup.get(name);
  }

  @Override
  public void clear(Player player) {
    menuStackMap.remove(player.getUniqueId());
  }
}
