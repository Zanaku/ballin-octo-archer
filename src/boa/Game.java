package boa;

import boa.controller.BattleController;
import boa.controller.PlayerController;
import boa.menu.Menu;
import boa.menu.StartMenu;

public final class Game {
    private final GameState state;
    private final PlayerController playerController;
    private final BattleController battleController;
    private Menu nextMenu;

    public Game() {
        this.state = new GameState();
        this.playerController = new PlayerController(this);
        this.battleController = new BattleController(this);
    }

    public void start() {
        this.setNextMenu(new StartMenu(this));

        // Loop calling the next menu given by the controllers, otherwise exit.
        // Needed because otherwise they recursively call each other and the
        // stack explodes.
        while (this.nextMenu != null) {
            Menu m = this.nextMenu;
            this.setNextMenu(null); // Controller must set the next menu.
            m.show();
        }
    }

    public GameState getState() {
        return this.state;
    }

    public PlayerController getPlayerController() {
        return this.playerController;
    }

    public BattleController getBattleController() {
        return this.battleController;
    }

    public void setNextMenu(final Menu m) {
        this.nextMenu = m;
    }
}
