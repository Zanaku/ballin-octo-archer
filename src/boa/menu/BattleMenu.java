package boa.menu;

import boa.Game;

public final class BattleMenu extends Menu {
    public BattleMenu(final Game game) {
        super();

        this.addItem(new MenuItem() {
            @Override
            public void trigger() {
                game.getBattleController().fight();
            }

            @Override
            public String getText() {
                return "Fight!";
            }
        });
    }
}
