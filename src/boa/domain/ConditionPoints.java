package boa.domain;

public class ConditionPoints {
	private Creature creature;
	private int health;
	
	public ConditionPoints(Creature creature) {
		this.creature = creature;
		this.reset();
	}
	
	public void reset()
	{
		this.health = this.creature.getStatusPoints().getHealth();
	}
	
	public int getHealth() { return this.health; }
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void decreaseHealth(int health) {
		this.health -= health;
	}
}
