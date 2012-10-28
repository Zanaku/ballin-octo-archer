package boa.domain;

/******************************************************************************/

public class Character extends Creature {
	private int experience = 0;
	
	/**************************************************************************/

	public Character(String name) {
		super(name, 1);
	}
	
	/**************************************************************************/

	public int getExperience() { return this.experience; }
	public void setExperience(int experience) {
		this.experience = experience;
	}
}
