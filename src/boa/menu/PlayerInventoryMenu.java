package boa.menu;

import boa.Game;

public class PlayerInventoryMenu extends Menu {
    public PlayerInventoryMenu(final Game game) {
        super();

        this.addItem(new MenuItem() {
            @Override
            public void trigger() {
                game.getPlayerInventoryController().showEquippedItems();
            }

            @Override
            public String getText() {
                return "Show Equipped Items";
            }
        });

        this.addItem(new MenuItem() {
            @Override
            public void trigger() {
                game.getPlayerInventoryController().showStoredItems();
            }

            @Override
            public String getText() {
                return "Show Stored Items";
            }
        });

        this.addItem(new MenuItem() {
            @Override
            public void trigger() {
                game.getPlayerInventoryController().equipItem();
            }

            @Override
            public String getText() {
                return "Equip Stored Item";
            }
        });
    }
}
