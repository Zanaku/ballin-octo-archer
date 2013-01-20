package boa.domain;

/**
 * Represents a named creature with a level, status points and condition points.
 */
public class Creature {
    private final String name;
    private int level;
    private StatusPoints statusPoints;
    private ConditionPoints conditionPoints;
    private final Inventory inventory;

    /**
     * Creates this creature with the specified name and level.
     * @param name Name of creature
     * @param level Level of creature. Must be a non-zero positive integer.
     */
    public Creature(final String name, final int level) {
        if (level <= 0) {
            throw new IllegalArgumentException("Level must be non-zero and positive.");
        }

        this.name = name;
        this.level = level;
        this.statusPoints = new StatusPoints();
        this.conditionPoints = new ConditionPoints();
        this.inventory = new Inventory();

        this.resetConditionPoints();
    }

    /**
     * Returns the name of this creature.
     * @return Name of creature
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Returns the level of this creature.
     * @return Level of creature
     */
    public final int getLevel() {
        return this.level;
    }

    /**
     * Sets the level of this creature.
     * @param level Level of creature
     */
    protected final void setLevel(final int level) {
        if (level <= 0) {
            throw new IllegalArgumentException("Level must be non-zero and positive.");
        }

        this.level = level;
    }

    /**
     * Returns a copy of this creature's status points.
     * @return Creature's status points
     */
    public final StatusPoints getStatusPoints() {
        return new StatusPoints(this.statusPoints);
    }

    /**
     * Sets this creature's status points to a copy of the specified instance.
     * @param s Creature's status points to be used
     */
    public final void setStatusPoints(final StatusPoints s) {
        this.statusPoints = new StatusPoints(s);
    }

    /**
     * Returns a copy of this creature's condition points.
     * @return Creature's condition points
     */
    public final ConditionPoints getConditionPoints() {
        return this.conditionPoints;
    }

    /**
     * Fully restores the condition points of this creature.
     */
    public final void resetConditionPoints() {
        this.conditionPoints = new ConditionPoints(this.getStatusPoints().getHealth() * 2);
    }

    /**
     * Removes the amount of damage from this creature's health
     * @param amount Amount of damage to be done
     */
    public final void takeDamage(final int amount) {
        this.conditionPoints.decreaseHealth(amount);
    }

    /**
     * Returns this creature's inventory.
     * @return Inventory
     */
    public final Inventory getInventory() {
        return this.inventory;
    }
}