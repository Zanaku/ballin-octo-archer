package boa.engine;

import java.util.EnumMap;
import java.util.Map;

public abstract class Game<T extends Game<T, K>, K extends Enum<K>> {
    private Class<K> stateEnumClass;

    private K currenState;
    private Map<K, GameController<T, K>> stateControllers;

    public Game(final Class<K> stateEnumClass) {
        this.stateEnumClass = stateEnumClass;

        this.currenState = null;
        this.stateControllers = new EnumMap<K, GameController<T, K>>(
                this.stateEnumClass);
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

        if (this.currenState != null) {
            this.stateControllers.get(state).stop();
        }

        this.currenState = state;
        this.stateControllers.get(state).start();
    }
}
