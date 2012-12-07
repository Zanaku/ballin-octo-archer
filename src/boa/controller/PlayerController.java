package boa.controller;

import boa.Game;
import boa.domain.Player;
import boa.menu.PlayerMenu;
import boa.util.CommandLine;

public class PlayerController extends Controller {
    public PlayerController(final Game game) {
        super(game);
    }

    public final void start() {
        new PlayerMenu(this.getGame()).show();
    }

    public final void createNewCharacter() {
        String name = CommandLine.getStringResponse("Name?");
        this.getGameState().setPlayer(new Player(name));

        new PlayerMenu(this.getGame()).show();
    }

    public final void showInfo() {
        Player player = this.getGameState().getPlayer();
        System.out.println(String.format("Name: %s\n" + "Level: %d\n" + "\n"
                + "Health: %d\n" + "Attack: %d\n" + "Defence: %d\n"
                + "Speed: %d\n", player.getName(), player.getLevel(), player
                .getStatusPoints().getHealth(), player.getStatusPoints()
                .getAttack(), player.getStatusPoints().getDefence(), player
                .getStatusPoints().getSpeed()));

        new PlayerMenu(this.getGame()).show();
    }
}
