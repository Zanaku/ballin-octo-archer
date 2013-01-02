package boa.controller;

import boa.Game;
import boa.domain.Player;
import boa.domain.StatusPoints;
import boa.menu.PlayerMenu;
import boa.util.CommandLine;

public class PlayerController extends Controller {
	final public static int STARTING_POINTS = 12;

	public PlayerController(final Game game) {
		super(game);
	}

	@Override
	public final void start() {
		this.getGame().setNextMenu(new PlayerMenu(this.getGame()));
	}

	public final void createNewCharacter() {
		String name = CommandLine.getStringResponse("What is your NAME?");
		Player player = new Player(name);

		player.setStatusPoints(this
				.getStartingStatusPoints(PlayerController.STARTING_POINTS));

		this.getGameState().setPlayer(player);
		this.getGame().setNextMenu(new PlayerMenu(this.getGame()));
	}

	/*
	 * Ask the user to assign status points to their character. They must use
	 * all of their status points so this will loop until that has been done.
	 */
	private StatusPoints getStartingStatusPoints(final int startingPoints) {
		int health, attack, defence, speed;
		int remaining = startingPoints;

		System.out
				.println(String
						.format("You have %d STATUS POINTS to spend. You must use all of them.",
								PlayerController.STARTING_POINTS));

		do {
			remaining = PlayerController.STARTING_POINTS;

			health = CommandLine.getIntResponseWithinBounds(1, remaining - 3,
					"How much HEALTH do you have?");
			remaining -= health;

			attack = CommandLine.getIntResponseWithinBounds(1, remaining - 2,
					"How much ATTACK do you have?");
			remaining -= attack;

			defence = CommandLine.getIntResponseWithinBounds(1, remaining - 1,
					"How much DEFENCE do you have?");
			remaining -= defence;

			speed = CommandLine.getIntResponseWithinBounds(1, remaining,
					"How many SPEED do you have?");
			remaining -= speed;

			if (remaining != 0) {
				System.out.println(String.format(
						"You must use all %d STATUS POINTS!",
						PlayerController.STARTING_POINTS));
			}
		} while (remaining != 0);

		return new StatusPoints(health, attack, defence, speed);
	}

	public final void showInfo() {
		Player player = this.getGameState().getPlayer();
		System.out.println(String.format("Name: %s\n" + "Level: %d\n" + "\n"
				+ "Health: %d\n" + "Attack: %d\n" + "Defence: %d\n"
				+ "Speed: %d\n", player.getName(), player.getLevel(), player
				.getStatusPoints().getHealth(), player.getStatusPoints()
				.getAttack(), player.getStatusPoints().getDefence(), player
				.getStatusPoints().getSpeed()));

		this.getGame().setNextMenu(new PlayerMenu(this.getGame()));
	}
}
