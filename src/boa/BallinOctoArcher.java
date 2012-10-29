package boa;

/******************************************************************************/

import java.util.Random;
import java.util.Scanner;

import boa.domain.Creature;
import boa.domain.Player;

/******************************************************************************/

public class BallinOctoArcher {
	private Player player;
	
	/**************************************************************************/

	public void printWelcome()
	{
		System.out.println(
				"===================================\n" +
				"= Welcome to Ballin-Octo-Archter! =\n" +
				"===================================\n" +
				"\n");
	}
	
	public void printPlayer()
	{
		System.out.println(this.player.toString());	
	}
	
	/**************************************************************************/

	public void createCharacter()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter your character's name: ");
		String characterName = s.nextLine();
		System.out.println();
		
		this.player = new Player(characterName);
		
		this.generateStats();
	}
	
	public void generateStats()
	{
		Random r = new Random();
		
		this.player.getStatusPoints().setHealth(r.nextInt(9) + 1);
		this.player.getStatusPoints().setAttack(r.nextInt(9) + 1);
		this.player.getStatusPoints().setDefence(r.nextInt(9) + 1);
		this.player.getStatusPoints().setSpeed(r.nextInt(9) + 1);
	}
	
	public void start() {
		this.printWelcome();
		this.createCharacter();
		this.printPlayer();	
		
		Creature c = new Creature("Assmaster", 1);
		c.getStatusPoints().setHealth(5);
		
		Fight f = new Fight(this.player, c);
		f.fight();
	}
	
	/**************************************************************************/

	public static void main(String[] args)
	{
		BallinOctoArcher b = new BallinOctoArcher();
		b.start();
	}
}
