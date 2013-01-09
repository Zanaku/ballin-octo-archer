package boa.menu;

import java.util.LinkedList;
import java.util.List;

import boa.util.CommandLine;

/**
 * A command-line based menu. Classes implementing the MenuItem interface will
 * receive a callback if the item is selected.
 */
public abstract class Menu {
    private List<MenuItem> items;

    /**
     * Constructor.
     */
    public Menu() {
        this.items = new LinkedList<>();
    }

    /**
     * Adds an item to this menu.
     * @param item Item to be added
     */
    public final void addItem(final MenuItem item) {
        this.items.add(item);
    }

    /**
     * Displays the list of choices available in this menu, asking the user for
     * a choice and then triggering that menu item's method.
     */
    public final void show() {
        this.printMenuItems();
        items.get(this.getChoiceIndex()).trigger();
    }

    /**
     * Prints a list of all items in this menu.
     */
    private void printMenuItems() {
        for (int i = 0; i < this.items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println(String.format("\t<%d> %s", i + 1, item.getText()));
        }
        System.out.println();
    }

    /**
     * Asks the user for a choice in this menu until a valid choice has been
     * made.
     * @return Index of item in the list
     */
    private int getChoiceIndex() {
        // Ask for a choice until a valid one has been made.
        int choiceIndex = -1;
        while (choiceIndex < 0 || choiceIndex > this.items.size() - 1) {
            choiceIndex = CommandLine.getIntResponse("Menu") - 1;
        }

        return choiceIndex;
    }
}
