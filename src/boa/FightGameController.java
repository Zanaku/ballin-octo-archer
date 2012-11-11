package boa;

public class FightGameController extends BoaGameController {
    public FightGameController(final BoaGame game, final BoaData boaData) {
        super(game, boaData);
    }

    @Override
    public final void start() {
        System.out.println("Fighto!");
    }
}
