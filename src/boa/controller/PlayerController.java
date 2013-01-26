package boa.controller;

import boa.Game;
import boa.domain.Player;
import boa.domain.StatusPoints;
import boa.menu.PlayerMenu;
import boa.util.CommandLine;

/**
 * Controller for performing all player-related logic, such as creating a new
 * character or viewing the status points of the player.
 */
public final class PlayerController extends Controller {
    public static final int STARTING_POINTS = 12;

    /**
     * Constructor.
     * @param game Game associated with this controller
     */
    public PlayerController(final Game game) {
        super(game);
    }

    /**
     * Starts this controller. Displays the main menu for this controller.
     */
    @Override
    public void start() {
        this.getGame().setNextMenu(new PlayerMenu(this.getGame()));
    }

    /**
     * Creates a new character, setting up the game state involved. This will
     * also request status points from the player and that sort of thing.
     */
    public void createNewCharacter() {
        String name = CommandLine.getStringResponse("What is your NAME?");
        Player player = new Player(name);

        player.setStatusPoints(this.getStartingStatusPoints(PlayerController.STARTING_POINTS));

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

        CommandLine.printlnIndented(String.format(
                "You have %d STATUS POINTS to spend. You must use all of them.",
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
                System.out.println(String.format("You must use all %d STATUS POINTS!",
                        PlayerController.STARTING_POINTS));
            }
        } while (remaining != 0);

        return new StatusPoints(health, attack, defence, speed);
    }

    /**
     * Prints the status of the player.
     */
    public void showInfo() {
        Player player = this.getGameState().getPlayer();
        CommandLine
                .printlnIndented(String.format("Name: %s\n" + "Level: %d\n" + "\n"
                        + "Base Health: %d\n" + "Base Attack: %d\n" + "Base Defence: %d\n"
                        + "Base Speed: %d", player.getName(), player.getLevel(), player
                        .getBaseStatusPoints().getHealth(), player.getBaseStatusPoints()
                        .getAttack(), player.getBaseStatusPoints().getDefence(), player
                        .getBaseStatusPoints().getSpeed()));

        CommandLine.printlnIndented(String.format("Total Health: %d\n" + "Total Attack: %d\n"
                + "Total Defence: %d\n" + "Total Speed: %d", player.getTotalStatusPoints()
                .getHealth(), player.getTotalStatusPoints().getAttack(), player
                .getTotalStatusPoints().getDefence(), player.getTotalStatusPoints().getSpeed()));

        this.getGame().setNextMenu(new PlayerMenu(this.getGame()));
    }
}
