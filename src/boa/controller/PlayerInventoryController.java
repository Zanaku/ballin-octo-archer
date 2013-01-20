package boa.controller;

import java.util.List;
import java.util.Map;

import boa.Game;
import boa.domain.Item;
import boa.domain.ItemType;
import boa.menu.PlayerInventoryMenu;
import boa.util.CommandLine;

public final class PlayerInventoryController extends Controller {
    public PlayerInventoryController(final Game game) {
        super(game);
    }

    public void showEquippedItems() {
        Map<ItemType, Item> items = this.getGameState().getPlayer().getInventory()
                .getEquippedItems();

        if (items.isEmpty()) {
            CommandLine.printlnIndented("--- Nothing is equiped ---");
        } else {
            for (Item item : items.values()) {
                System.out.println(String.format("\t[%s] %s", item.getType().toString(),
                        item.getName()));
            }
            System.out.println();
        }

        this.getGame().setNextMenu(new PlayerInventoryMenu(this.getGame()));
    }

    public void showStoredItems() {
        List<Item> items = this.getGameState().getPlayer().getInventory().getStoredItems();

        if (items.isEmpty()) {
            CommandLine.printlnIndented("--- Nothing is in the inventory ---");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);

                System.out.println(String.format("\t[%d : %s] %s", i + 1,
                        item.getType().toString(), item.getName()));
            }

            System.out.println();
        }

        this.getGame().setNextMenu(new PlayerInventoryMenu(this.getGame()));
    }

    public void equipItem() {
        int itemIndex = CommandLine.getIntResponse("What ITEM NUMBER do you wish to equip?");

        Item item = this.getGameState().getPlayer().getInventory().getStoredItems()
                .get(itemIndex - 1);
        this.getGameState().getPlayer().getInventory().equipItem(item);

        this.getGame().setNextMenu(new PlayerInventoryMenu(this.getGame()));
    }

    @Override
    public void start() {
        this.getGame().setNextMenu(new PlayerInventoryMenu(this.getGame()));
    }
}
