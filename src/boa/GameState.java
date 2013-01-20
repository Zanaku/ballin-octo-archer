package boa;

import boa.domain.Player;

/**
 * Represents the game state.
 */
public final class GameState {
    private Player player;

    /**
     * Sets the player for this state.
     * @param player Player to be set
     */
    public void setPlayer(final Player player) {
        this.player = player;
    }

    /**
     * Returns the user's player.
     * @return Player
     */
    public Player getPlayer() {
        return this.player;
    }
}
