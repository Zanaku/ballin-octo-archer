package boa;

import boa.domain.Player;

public final class GameState {
    private Player player;

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }
}
