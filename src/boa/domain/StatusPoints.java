package boa.domain;

/******************************************************************************/

public class StatusPoints {
	private int health = 1; //THIS IS UR GOODS
	private int strength = 1; //THIS IS UR STRONGS
	private int defence = 1; //THIS UR BEEF
	private int speed = 1; //THIS IS UR RUNS
	
	/**************************************************************************/

	public int getHealth() { return this.health; }
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**************************************************************************/

	public int getStrength() { return this.strength; }
	public void setStrength(int strength) {
		this.strength = strength;
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
}
