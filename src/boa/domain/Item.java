package boa.domain;

/**
 * Represents an item in the game world.
 */
public final class Item {
    private String name;
    private ItemType type;
    private StatusPoints bonusStatusPoints;

    /**
     * Constructor.
     * @param name Name of this item
     * @param type Type of this item, such as what slot it will fit into.
     * @param bonusStatusPoints Status points this item will give.
     */
    public Item(final String name, final ItemType type, final StatusPoints bonusStatusPoints) {
        this.name = name;
        this.type = type;
        this.bonusStatusPoints = bonusStatusPoints;
    }

    /**
     * Constructor. Defaults to having zero status points.
     * @param name Name of this item.
     * @param type Type of this item, such as what slot it will fit into.
     */
    public Item(final String name, final ItemType type) {
        this(name, type, new StatusPoints());
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

    /**
     * Returns the status point modifiers of this item.
     * @return Modifier status points
     */
    public StatusPoints getBonusStatusPoints() {
        return this.bonusStatusPoints;
    }
}
