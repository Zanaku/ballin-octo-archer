package boa;

import boa.controller.PlayerController;
import boa.menu.Menu;

public class Game {
	private final GameState state;
	private final PlayerController playerController;
	private Menu nextMenu;

	public Game() {
		this.state = new GameState();
		this.playerController = new PlayerController(this);
	}

	public final void start() {
		this.getPlayerController().start();

		// Loop calling the next menu given by the controllers, otherwise exit.
		// Needed because otherwise they recursively call each other and the
		// stack explodes.
		while (this.nextMenu != null) {
			Menu m = this.nextMenu;
			this.setNextMenu(null); // Controller must set the next menu.
			m.show();
		}
	}

	public final GameState getState() {
		return this.state;
	}

	public final PlayerController getPlayerController() {
		return this.playerController;
	}

	public final void setNextMenu(final Menu m) {
		this.nextMenu = m;
	}
}
