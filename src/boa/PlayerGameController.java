package boa;

import boa.engine.Menu;
import boa.engine.MenuItem;

public class PlayerGameController extends BoaGameController {
    public PlayerGameController(final BoaGame game, final BoaData boaData) {
        super(game, boaData);
    }

    @Override
    public final void start() {
        Menu startMenu = new Menu();
        startMenu.addItem(new MenuItem() {
            @Override
            public void trigger() {
                System.out.println("Test");
            }

            @Override
            public String getText() {
                return "Test";
            }
        });

        startMenu.addItem(new MenuItem() {
            @Override
            public void trigger() {
                System.out.println("Test 2");
            }

            @Override
            public String getText() {
                return "Test 2";
            }
        });

        startMenu.show();
    }
}
