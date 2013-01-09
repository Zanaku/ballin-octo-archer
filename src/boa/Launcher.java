package boa;

public final class Launcher {
    private Launcher() {
        throw new UnsupportedOperationException();
    }

    public static void main(final String[] args) {
        new Game().start();
    }
}
