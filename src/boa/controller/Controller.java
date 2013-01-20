package boa.controller;

import boa.Game;
import boa.GameState;

/**
 * An abstract controller used to perform game logic.
 */
public abstract class Controller {
    private Game game;

    /**
     * Constructor.
     * @param game Game this controller is attached to
     */
    public Controller(final Game game) {
        this.game = game;
    }

    /**
     * Returns the game associated with this controller.
     * @return Game associated with this controller
     */
    public final Game getGame() {
        return this.game;
    }

    /**
     * Returns the game state of the game associated with this controller.
     * @return State of the game associated with this controller
     */
    protected final GameState getGameState() {
        return this.game.getState();
    }

    /**
     * "Entry-point" for this controller. Called when if we need to move to this
     * controller.
     */
    public abstract void start();
}
