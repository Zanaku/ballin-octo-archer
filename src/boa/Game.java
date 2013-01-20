package boa;

import boa.controller.BattleController;
import boa.controller.PlayerController;
import boa.controller.PlayerInventoryController;
import boa.menu.Menu;
import boa.menu.StartMenu;

/**
 * Represents the BOA game, storing all controllers and handling menu switching.
 */
public final class Game {
    private final GameState state;
    private final PlayerController playerController;
    private final PlayerInventoryController playerInventoryController;
    private final BattleController battleController;
    private Menu nextMenu;

    /**
     * Constructor.
     */
    public Game() {
        this.state = new GameState();
        this.playerController = new PlayerController(this);
        this.battleController = new BattleController(this);
        this.playerInventoryController = new PlayerInventoryController(this);
    }

    /**
     * Starts the game, specifically the menu logic that drives gameplay. It
     * loops, taking the next set menu and displays it. The
     * process will continue as long as a next menu is set.
     */
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

    /**
     * Sets the next menu to be displayed after the current one finishes
     * processing.
     * @param m Menu to be displayed
     */
    public void setNextMenu(final Menu m) {
        this.nextMenu = m;
    }

    /**
     * Returns the game state.
     * @return Game state
     */
    public GameState getState() {
        return this.state;
    }

    public PlayerController getPlayerController() {
        return this.playerController;
    }

    public PlayerInventoryController getPlayerInventoryController() {
        return this.playerInventoryController;
    }

    public BattleController getBattleController() {
        return this.battleController;
    }
}
