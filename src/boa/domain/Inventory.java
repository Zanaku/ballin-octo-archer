package boa.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents an inventory of items, split into equipped items and stored items.
 */
public final class Inventory {
    private Map<ItemType, Item> equippedItems;
    private LinkedList<Item> storedItems;

    /**
     * Constructor.
     */
    public Inventory() {
        this.equippedItems = new EnumMap<>(ItemType.class);
        this.storedItems = new LinkedList<>();

        this.storedItems.add(new Item("Test Body", ItemType.BODY));
        this.storedItems.add(new Item("Test Pants", ItemType.PANTS));
        this.storedItems.add(new Item("Test Weapon", ItemType.WEAPON));
    }

    /**
     * Equips an item on this inventory. If an item is already equipped in that
     * slot, it will be moved in with the stored items. If the item is already
     * stored, it will be removed from the stored items.
     * @param item Item to be equipped
     */
    public void equipItem(final Item item) {
        // Unequip an item if it is equipped already.
        if (this.equippedItems.get(item.getType()) != null) {
            this.storedItems.add(this.equippedItems.get(item.getType()));
        }

        // Remove it from our stored item list if it exists.
        if (this.storedItems.contains(item)) {
            this.storedItems.remove(item);
        }

        this.equippedItems.put(item.getType(), item);
    }

    /**
     * Stores an item in this invetory's item store.
     * @param item The item to be stored
     */
    public void storeItem(final Item item) {
        this.storedItems.add(item);
    }

    /**
     * Returns an unmodifiable map of currently equipped items.
     * @return An unmodifiable map of items
     */
    public Map<ItemType, Item> getEquippedItems() {
        return Collections.unmodifiableMap(this.equippedItems);
    }

    /**
     * Returns an unmodiable list of items stored in this inventory.
     * @return An unmodiable list of items
     */
    public List<Item> getStoredItems() {
        return Collections.unmodifiableList(this.storedItems);
    }
}