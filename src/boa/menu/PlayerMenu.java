package boa.menu;

import boa.Game;

public final class PlayerMenu extends Menu {
    public PlayerMenu(final Game game) {
        super();

        // Add menu items.
        if (game.getState().getPlayer() == null) {
            // Show new character option as no existing character exists.
            this.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    game.getPlayerController().createNewCharacter();
                }

                @Override
                public String getText() {
                    return "New Character";
                }
            });
        } else {
            // Show the show status option as the player has a character.
            this.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    game.getPlayerController().showInfo();
                }

                @Override
                public String getText() {
                    return "Show Info";
                }
            });

            // Show the inventory menu
            this.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    game.getPlayerInventoryController().start();
                }

                @Override
                public String getText() {
                    return "Inventory";
                }
            });

            // Return to the start menu
            this.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    game.setNextMenu(new StartMenu(game));
                }

                @Override
                public String getText() {
                    return "Go Back";
                }
            });
        }

    }
}
