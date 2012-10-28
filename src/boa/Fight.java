package boa;

import java.util.Random;

import boa.domain.Creature;
import boa.domain.Player;

public class Fight {
	private Player player;
	private Creature creature;
	
	public Fight(Player player, Creature creature) {
		this.player = player;
		this.creature = creature;
	}
	
	public void fight() {
		player.getConditionPoints().reset();
		creature.getConditionPoints().reset();
		
		Random r = new Random();
		boolean turn = r.nextBoolean();
		
		while (player.getConditionPoints().getHealth() > 0 &&
				creature.getConditionPoints().getHealth() > 0) {
			if (turn) { // player's turn
				System.out.println("Player's turn");
				
				creature.getConditionPoints().decreaseHealth(
						player.getStatusPoints().getStrength());
				
				System.out.println("Creature takes " + 
						player.getStatusPoints().getStrength() + " damage");
			} else { // creature's turn
				System.out.println("Creature's turn");
				
				player.getConditionPoints().decreaseHealth(
						creature.getStatusPoints().getStrength());
				
				System.out.println("Player takes " + 
						creature.getStatusPoints().getStrength() + " damage");
			}
			
			System.out.println();
			System.out.println("Player HP: " +
					player.getConditionPoints().getHealth());
			System.out.println("Creature HP: " +
					creature.getConditionPoints().getHealth());
			
			turn = !turn;
		}
	}
}
