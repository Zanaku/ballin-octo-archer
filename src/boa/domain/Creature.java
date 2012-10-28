package boa.domain;

/******************************************************************************/

public class Creature {
	private String name;
	private int level;
	private StatusPoints statusPoints;
	private ConditionPoints conditionPoints;
	
	/**************************************************************************/
	
	public Creature(String name, int level) {
		this.name = name;
		this.level = level;
		this.statusPoints = new StatusPoints();
		this.conditionPoints = new ConditionPoints(this);
	}
	
	/**************************************************************************/
	
	public String getName() { return this.name; }
	public void setName(String name) {
		this.name = name;
	}
	
	/**************************************************************************/

	public int getLevel() {	return this.level; }	
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**************************************************************************/

	public StatusPoints getStatusPoints() { return this.statusPoints; }
	public ConditionPoints getConditionPoints() {
		return this.conditionPoints;
	}
}
