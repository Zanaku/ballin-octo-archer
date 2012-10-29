package boa.domain;

/******************************************************************************/

public class StatusPoints {
	private int health = 1; //THIS IS UR GOODS
	private int attack = 1; //THIS IS UR STRONGS
	private int defence = 1; //THIS UR BEEF
	private int speed = 1; //THIS IS UR RUNS
	
	/**************************************************************************/

	public int getHealth() { return this.health; }
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**************************************************************************/

	public int getAttack() { return this.attack; }
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**************************************************************************/

	public int getDefence() { return this.defence; }
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	/**************************************************************************/

	public int getSpeed() {	return this.speed; }
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**************************************************************************/

	public String toString() {
		return String.format(
				"Health: %d\n" +
				"Defence: %d\n" +
				"Attack: %d\n" +
				"Speed: %d",
				this.getHealth(),
				this.getDefence(),
				this.getAttack(),
				this.getSpeed());
	}
}
