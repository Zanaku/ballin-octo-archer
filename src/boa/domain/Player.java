package boa.domain;

/**
 * Represents a user-controlled player.
 */
public class Player extends Creature {
    private int experience;

    /**
     * Creates this player instance with the specified name.
     * @param name Player's name
     */
    public Player(final String name) {
        super(name, 1);

        this.experience = 0;
    }

    /**
     * Returns the current number of experience points that the player has
     * gained at this level.
     * @return Current number of experience points that this player has
     */
    public final int getExperience() {
        return this.experience;
    }

    /**
     * Increases the number of experience points that this player has by the
     * specified amount. This player will be increased to the next level if the
     * experience passes the required threshold.
     * @param amount Amount of experience to increase this player's experience
     *            points by.
     */
    public final void increaseExperience(final int amount) {
        this.experience += experience;

        if (this.experience >= this.getExperienceNeeded()) {
            // Reset the experience, wrapping any left over into the next level.
            this.experience %= this.getExperienceNeeded();

            this.setLevel(this.getLevel() + 1);
        }
    }

    /**
     * Calculates the number of experience points required to level up at this
     * player's current level.
     * @return Experience required to level up at this player's current level
     */
    public final int getExperienceNeeded() {
        return getExperienceNeeded(this.getLevel());
    }

    /**
     * Calculates the number of experience points required to level up at the
     * specified level.
     * 
     * The experience progression at this current point in time is simply
     * linear.
     * @param level Level at which to calculate the experience needed
     * @return Experience required to level up at the specified level
     */
    public final int getExperienceNeeded(final int level) {
        final int multiplier = 10;

        return multiplier * level;
    }
}
