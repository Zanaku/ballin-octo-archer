package boa.domain;

/******************************************************************************/

public class Player extends Creature {
	private int experience = 0;
	
	/**************************************************************************/

	public Player(String name) {
		super(name, 1);
	}
	
	/**************************************************************************/

	public int getExperience() { return this.experience; }
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	/**************************************************************************/

	public String toString()
	{
		return String.format(
				"%s\n\n%s\n",
				this.getName(), 
				this.getStatusPoints().toString());
	}
}
