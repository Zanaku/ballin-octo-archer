package boa.menu;

import boa.Game;

public final class StartMenu extends Menu {
    public StartMenu(final Game game) {
        super();

        this.addItem(new MenuItem() {
            @Override
            public void trigger() {
                game.getPlayerController().start();
            }

            @Override
            public String getText() {
                return "Player";
            }
        });

        if (game.getState().getPlayer() != null) {
            this.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    game.getBattleController().start();
                }

                @Override
                public String getText() {
                    return "Battle";
                }
            });
        }
    }
}
