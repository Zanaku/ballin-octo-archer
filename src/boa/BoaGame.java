package boa;

import boa.engine.Game;

public class BoaGame extends Game<BoaGame, BoaGame.State> {
    private BoaData boaData;

    public enum State {
        PLAYER, FIGHT
    }

    public BoaGame() {
        super(State.class);

        this.boaData = new BoaData();

        this.addStateController(BoaGame.State.PLAYER, new PlayerGameController(
                this, this.boaData));
        this.addStateController(BoaGame.State.FIGHT, new FightGameController(
                this, this.boaData));
    }

    @Override
    public final void start() {
        this.switchState(BoaGame.State.PLAYER);
    }
}
