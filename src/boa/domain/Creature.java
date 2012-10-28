package boa.domain;

/******************************************************************************/

public class Creature {
	private String name;
	private int level;
	private StatusPoints statusPoints;
	
	/**************************************************************************/
	
	public Creature(String name, int level) {
		this.name = name;
		this.level = level;
		this.statusPoints = new StatusPoints();
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
}
