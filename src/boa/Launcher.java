package boa;

/**
 * Entry point for the game.
 */
public final class Launcher {
    /**
     * Constructor -- should not be called.
     */
    private Launcher() {
        throw new UnsupportedOperationException();
    }

    /**
     * Main function and entry point.
     */
    public static void main(final String[] args) {
        // Create the game and start it.
        new Game().start();
    }
}
