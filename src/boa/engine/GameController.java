package boa.engine;

public abstract class GameController<T extends Game<T, K>, K extends Enum<K>> {
    private T game;

    public GameController(final T game) {
        this.game = game;
    }

    public abstract void start();
    public void stop() {

    }

    protected final T getGame() {
        return this.game;
    }
}