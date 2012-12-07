package boa.menu;

/**
 * A menu item used in the Menu class.
 */
public interface MenuItem {
    /**
     * Called when this menu item is selected.
     */
    void trigger();

    /**
     * Returns the text used when displaying this item in the menu.
     * @return a String representing this menu item.
     */
    String getText();
}
