package boa.controller;

import boa.Game;
import boa.GameState;

public abstract class Controller {
    private Game game;

    public Controller(final Game game) {
        this.game = game;
    }

    public final Game getGame() {
        return this.game;
    }

    protected final GameState getGameState() {
        return this.game.getState();
    }

    public abstract void start();
}
