package rip.hippo.spigotmenu.builder;

/**
 * @author Hippo
 */
public final class MenuRowStagedBuilder {

  private final MenuTitleStagedBuilder menuTitleStagedBuilder;

  private int rows;

  public MenuRowStagedBuilder(MenuTitleStagedBuilder menuTitleStagedBuilder) {
    this.menuTitleStagedBuilder = menuTitleStagedBuilder;
  }

  public MenuMetaDataStagedBuilder rows(int rows) {
    this.rows = rows;
    return new MenuMetaDataStagedBuilder(this);
  }

  int getRows() {
    return rows;
  }

  int getSize() {
    return rows * 9;
  }

  MenuTitleStagedBuilder getMenuNameStagedBuilder() {
    return menuTitleStagedBuilder;
  }
}
