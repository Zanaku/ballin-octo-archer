package boa.domain;

/**
 * Represents an item in the game world.
 */
public final class Item {
    private String name;
    private ItemType type;

    /**
     * Constructor.
     * @param name Name of this item
     * @param type Type of this item, such as what slot it will fit into.
     */
    public Item(final String name, final ItemType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the name of this item.
     * @return Item name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the type of this item.
     * @return Item type
     */
    public ItemType getType() {
        return this.type;
    }
}
