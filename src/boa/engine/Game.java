package boa.engine;

import java.util.EnumMap;
import java.util.Map;

public abstract class Game<T extends Game<T, K>, K extends Enum<K>> {
    private Class<K> stateClass;

    private K currentState;
    private Map<K, GameController<T, K>> stateControllers;

    public Game(final Class<K> stateClass) {
        this.stateClass = stateClass;

        this.currentState = null;
        this.stateControllers = new EnumMap<K, GameController<T, K>>(
                this.stateClass);
    }

    public abstract void start();

    protected final void addStateController(final K s,
            final GameController<T, K> state) {
        this.stateControllers.put(s, state);
    }

    public final void switchState(final K state) {
        if (!this.stateControllers.containsKey(state)) {
            throw new IllegalArgumentException(String.format(
                    "State #%s does not exist.", state.toString()));
        }

        if (this.currentState != null) {
            this.stateControllers.get(this.currentState).stop();
        }

        this.currentState = state;
        this.stateControllers.get(state).start();
    }
}
