package boa.domain;

/**
 * A structure representing the status points of some creature entity.
 */
public class StatusPoints {
    private int health;
    private int attack;
    private int defence;
    private int speed;

    /**
     * Creates this structure with all points set to 0.
     */
    public StatusPoints() {
        this.health = 0;
        this.attack = 0;
        this.defence = 0;
        this.speed = 0;
    }

    /**
     * Creates this structure using the specified values.
     * @param health Health. Must be a positive number.
     * @param attack Attack. Must be a positive number.
     * @param defence Defence. Must be a positive number.
     * @param speed Speed. Must be a positive number.
     */
    public StatusPoints(final int health, final int attack, final int defence,
            final int speed) {
        if (health < 0) {
            throw new IllegalArgumentException(
                    "Health must be a positive number.");
        } else if (attack < 0) {
            throw new IllegalArgumentException(
                    "Attack must be a positive number.");
        } else if (defence < 0) {
            throw new IllegalArgumentException(
                    "Defence must be a positive number.");
        } else if (speed < 0) {
            throw new IllegalArgumentException(
                    "Speed must be a positive number.");
        }

        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    /**
     * Creatures this structure by copying an existing status point structure.
     * @param s Status point structure to be copied
     */
    public StatusPoints(final StatusPoints s) {
        this.attack = s.getAttack();
        this.health = s.getHealth();
        this.defence = s.getDefence();
        this.speed = s.getSpeed();
    }

    /**
     * Returns the health status point of this structure.
     * @return Health
     */
    public final int getHealth() {
        return this.health;
    }

    /**
     * Returns the attack status point of this structure.
     * @return Attack
     */
    public final int getAttack() {
        return this.attack;
    }

    /**
     * Returns the defence status point of this structure.
     * @return Defence
     */
    public final int getDefence() {
        return this.defence;
    }

    /**
     * Returns the speed status point of this structure.
     * @return Speed
     */
    public final int getSpeed() {
        return this.speed;
    }
}
