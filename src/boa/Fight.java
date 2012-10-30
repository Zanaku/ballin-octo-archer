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
				System.out.println(player.getName()+"'s turn");
				
				creature.getConditionPoints().decreaseHealth(
						player.getStatusPoints().getAttack());
				
				System.out.println(creature.getName() + " takes " + 
						player.getStatusPoints().getAttack() + " damage");
			} else { // creature's turn
				System.out.println(creature.getName()+"'s turn");
				
				player.getConditionPoints().decreaseHealth(
						creature.getStatusPoints().getAttack());
				
				System.out.println(creature.getName() + " takes " + 
						creature.getStatusPoints().getAttack() + " damage");
			}
			
			System.out.println();
			System.out.println(player.getName()+"'s HP: " +
					player.getConditionPoints().getHealth());
			System.out.println(creature.getName()+"'s HP: " +
					creature.getConditionPoints().getHealth());
			
			turn = !turn;
		}
	}
}
