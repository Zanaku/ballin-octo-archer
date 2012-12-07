package boa.menu;

import boa.Game;

public class PlayerMenu extends Menu {
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
            // Show the show stats option as the player has a character.
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
        }
    }
}
