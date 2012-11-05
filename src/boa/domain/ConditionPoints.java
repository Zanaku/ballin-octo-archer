package boa.domain;

/**
 * A structure used to hold the current condition points of a particular
 * creature.
 */
public class ConditionPoints {
    private int maximumHealth;
    private int health;

    /**
     * Creates this structure with maximum health set to zero. Not much use that
     * now, is it? Silly sausage.
     */
    public ConditionPoints() {
        this.maximumHealth = 0;
        this.health = maximumHealth;
    }

    /**
     * Creates this structure with the specified maximum health.
     * @param maximumHealth Maximum health of the attached creature
     */
    public ConditionPoints(final int maximumHealth) {
        this.maximumHealth = maximumHealth;
        this.health = this.maximumHealth;
    }

    /**
     * Creates this structure with the specified maximum health and current
     * health.
     * @param maximumHealth Maximum health of the creature
     * @param health Current health of the creature
     */
    public ConditionPoints(final int maximumHealth, final int health) {
        this.maximumHealth = maximumHealth;
        this.health = health;
    }

    /**
     * Creates this structure by copying an existing condition point structure.
     * @param c Existing structure to copy
     */
    public ConditionPoints(final ConditionPoints c) {
        this(c.getMaximumHealth(), c.getHealth());
    }

    /**
     * Returns the maximum health of the creature.
     * @return Maximum health of the creature
     */
    public final int getMaximumHealth() {
        return this.maximumHealth;
    }

    /**
     * Returns the current health of the creature.
     * @return Current health of the creature
     */
    public final int getHealth() {
        return this.health;
    }

    /**
     * Increases the current health of the creature by the provided amount. This
     * will clamp the health to the maximum and minimum possible.
     * @param amount Amount to increase health by
     */
    public final void increaseHealth(final int amount) {
        this.health += amount;
        this.clampHealth();
    }

    /**
     * Decreases the current health of the creature by the provided amount. This
     * will clamp the health to the maximum and minimum possible.
     * @param amount Amount to decrease health by
     */
    public final void decreaseHealth(final int amount) {
        this.health -= amount;
        this.clampHealth();
    }

    /**
     * Checks that current health is within appropriate bounds, clamping it at
     * the minimum and maximum values if necessary.
     */
    private void clampHealth() {
        if (this.health < 0) {
            this.health = 0;
        } else if (this.health > this.maximumHealth) {
            this.health = this.maximumHealth;
        }
    }
}
