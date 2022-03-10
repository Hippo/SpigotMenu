package rip.hippo.spigotmenu.builder;

import rip.hippo.spigotmenu.container.MenuContainer;

/**
 * @author Hippo
 */
public final class MenuTitleStagedBuilder {

  private final MenuContainer menuContainer;
  private String title;

  public MenuTitleStagedBuilder(MenuContainer menuContainer) {
    this.menuContainer = menuContainer;
  }

  public MenuRowStagedBuilder title(String title) {
    this.title = title;
    return new MenuRowStagedBuilder(this);
  }

  String getTitle() {
    return title;
  }

  MenuContainer getMenuContainer() {
    return menuContainer;
  }
}
