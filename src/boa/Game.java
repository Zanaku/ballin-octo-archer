package boa;

public class Game {
    private GameState state;
    private PlayerController playerController;

    public Game() {
        this.state = new GameState();
        this.playerController = new PlayerController(this);
    }

    public final void start() {
        this.getPlayerController().start();
    }


    public final GameState getState() {
        return state;
    }

    public final PlayerController getPlayerController() {
        return this.playerController;
    }
}
