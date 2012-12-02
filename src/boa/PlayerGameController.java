package boa;

import boa.domain.Player;
import boa.engine.CommandLine;
import boa.engine.Menu;
import boa.engine.MenuItem;

public class PlayerGameController extends BoaGameController {
    public PlayerGameController(final BoaGame game, final BoaData boaData) {
        super(game, boaData);
    }

    private void showMenu() {
        Menu startMenu = new Menu();

        if (this.getBoaData().getPlayer() == null) {
            // Show new character option as no existing character exists.
            startMenu.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    PlayerGameController.this.createNewCharacter();
                }

                @Override
                public String getText() {
                    return "New Character";
                }
            });
        } else {
            startMenu.addItem(new MenuItem() {
                @Override
                public void trigger() {
                    PlayerGameController.this.showStats();
                }

                @Override
                public String getText() {
                    return "Show Info";
                }
            });
        }

        startMenu.show();
    }

    private void createNewCharacter() {
        String name = CommandLine.getStringResponse("Name?");
        this.getBoaData().setPlayer(new Player(name));

        this.showMenu();
    }

    private void showStats() {
        Player player = this.getBoaData().getPlayer();

        System.out.println(String.format("Name: %s\n" + "Level: %d\n" + "\n"
                + "Health: %d\n" + "Attack: %d\n" + "Defence: %d\n"
                + "Speed: %d\n", player.getName(), player.getLevel(), player
                .getStatusPoints().getHealth(), player.getStatusPoints()
                .getAttack(), player.getStatusPoints().getDefence(), player
                .getStatusPoints().getSpeed()));

        this.showMenu();
    }

    @Override
    public final void start() {
        this.showMenu();
    }
}
