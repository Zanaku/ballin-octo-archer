package boa.controller;

import java.util.Random;

import boa.Game;
import boa.domain.Creature;
import boa.domain.Player;
import boa.domain.StatusPoints;
import boa.menu.BattleMenu;
import boa.util.CommandLine;

public final class BattleController extends Controller {
    public BattleController(final Game game) {
        super(game);
    }

    public void fight() {
        Player player = this.getGameState().getPlayer();

        Creature creature = new Creature("Zombie", player.getLevel());
        creature.setStatusPoints(new StatusPoints(player.getStatusPoints()));

        player.resetConditionPoints();
        creature.resetConditionPoints();

        Random r = new Random();
        boolean playerTurn = true;
        while ((player.getConditionPoints().getHealth() > 1)
                && (creature.getConditionPoints().getHealth() > 1)) {
            Creature attacker;
            Creature defender;
            if (playerTurn) {
                attacker = player;
                defender = creature;
            } else {
                attacker = creature;
                defender = player;
            }

            int attack = r.nextInt(attacker.getStatusPoints().getAttack() + 1);
            if (attack > 0) {
                defender.takeDamage(attack);

                CommandLine.printlnIndented(String.format("%s hits %s for %d damage!",
                        attacker.getName(), defender.getName(), attack));
            } else {
                CommandLine.printlnIndented(String.format("%s misses!", attacker.getName()));
            }

            CommandLine.printlnIndented(String.format("%s [HP: %d]\n%s [HP: %d]", player.getName(),
                    player
                    .getConditionPoints().getHealth(), creature.getName(), creature
                    .getConditionPoints().getHealth()));

            playerTurn = !playerTurn;
        }

        player.resetConditionPoints();
        creature.resetConditionPoints();

        this.getGame().setNextMenu(new BattleMenu(this.getGame()));
    }

    @Override
    public void start() {
        CommandLine.printlnIndented("FIGHTO");

        this.getGame().setNextMenu(new BattleMenu(this.getGame()));
    }
}
