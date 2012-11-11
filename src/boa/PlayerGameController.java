package boa;

public class PlayerGameController extends BoaGameController {
    public PlayerGameController(final BoaGame game, final BoaData boaData) {
        super(game, boaData);
    }

    @Override
    public final void start() {
        System.out.println("Video games");

        this.getGame().switchState(BoaGame.State.FIGHT);
    }
}
