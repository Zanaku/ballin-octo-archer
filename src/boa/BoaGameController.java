package boa;

import boa.engine.GameController;

public abstract class BoaGameController extends
        GameController<BoaGame, BoaGame.State> {
    private BoaData boaData;

    public BoaGameController(final BoaGame game, final BoaData boaData) {
        super(game);

        this.boaData = boaData;
    }

    protected final BoaData getBoaData() {
        return this.boaData;
    }
}
