package rip.hippo.spigotmenu.builder;

import rip.hippo.spigotmenu.Menu;
import rip.hippo.spigotmenu.component.MenuComponent;

/**
 * @author Hippo
 */
public final class MenuMetaDataStagedBuilder {

  private final MenuRowStagedBuilder menuRowStagedBuilder;
  private final MenuComponent[] menuComponents;
  private boolean allowDragging;

  public MenuMetaDataStagedBuilder(MenuRowStagedBuilder menuRowStagedBuilder) {
    this.menuRowStagedBuilder = menuRowStagedBuilder;
    this.menuComponents = new MenuComponent[menuRowStagedBuilder.getSize()];
  }

  public MenuMetaDataStagedBuilder allowDragging() {
    this.allowDragging = true;
    return this;
  }

  public MenuMetaDataStagedBuilder addComponent(int slot, MenuComponent menuComponent) {
    if (slot >= menuComponents.length) {
      throw new IndexOutOfBoundsException("Tried to insert menu component out of bounds! size: " + menuComponents.length + " slot: " + slot);
    }
    menuComponents[slot] = menuComponent;
    return this;
  }

  /**
   * Deploys the menu.
   * It is <b>recommended</b> to namespace this name to avoid collision with other plugins.
   * The name is only used to look up menu instances, this is <b>not</b> the title of the menu.
   * <p>
   *   Instead of having the lookup be "MyMenu", use "MyPlugin:MyMenu:"
   * </p>
   *
   * @param name the name.
   */
  public void deploy(String name) {
    MenuRowStagedBuilder rowBuilder = getMenuRowStagedBuilder();
    MenuTitleStagedBuilder titleBuilder = rowBuilder.getMenuNameStagedBuilder();
    Menu menu = new Menu(titleBuilder.getTitle(),
        rowBuilder.getRows(),
        allowDragging,
        menuComponents);
    titleBuilder.getMenuContainer().register(name, menu);
  }

  MenuRowStagedBuilder getMenuRowStagedBuilder() {
    return menuRowStagedBuilder;
  }
}
