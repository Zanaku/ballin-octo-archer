package boa.domain;

/**
 * A structure used to hold the current condition points of a particular
 * creature.
 */
public final class ConditionPoints {
    private final int maximumHealth;
    private int health;

    /**
     * Creates this structure with maximum health set to 1.
     */
    public ConditionPoints() {
        this.maximumHealth = 1;
        this.health = maximumHealth;
    }

    /**
     * Creates this structure with the specified maximum health.
     * @param maximumHealth Maximum health of the creature. Must be a non-zero
     *            positive number.
     */
    public ConditionPoints(final int maximumHealth) {
        if (maximumHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be a positive non-zero number.");
        }

        this.maximumHealth = maximumHealth;
        this.health = this.maximumHealth;
    }

    /**
     * Creates this structure with the specified maximum health and current
     * health.
     * @param maximumHealth Maximum health of the creature. Must be a non-zero
     *            positive number.
     * @param health Current health of the creature. Must be a positive
     *            number.
     */
    public ConditionPoints(final int maximumHealth, final int health) {
        if (maximumHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be a positive non-zero number.");
        } else if (health < 0) {
            throw new IllegalArgumentException("Health must be a positive number.");
        }

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
    public int getMaximumHealth() {
        return this.maximumHealth;
    }

    /**
     * Returns the current health of the creature.
     * @return Current health of the creature
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Increases the current health of the creature by the provided amount. This
     * will clamp the health to the maximum and minimum possible.
     * @param amount Amount to increase health by
     */
    public void increaseHealth(final int amount) {
        this.health += amount;
        this.clampHealth();
    }

    /**
     * Decreases the current health of the creature by the provided amount. This
     * will clamp the health to the maximum and minimum possible.
     * @param amount Amount to decrease health by
     */
    public void decreaseHealth(final int amount) {
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
