package observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * The Observer pattern is for sure one of the most common and widely used pattern.
 * Its purpose is allowing one or more objects to to be notified when a certain event occurs and act accordingly.
 */
public class Observable {
    private final Map<Object, Consumer<Object>> listeners = new ConcurrentHashMap<>();

    public void register(Object key, Consumer<Object> listener) {
        listeners.put(key, listener);
    }

    public void unregister(Object key) {
        listeners.remove(key);
    }

    public void sendEvent(Object event) {
        listeners.values().forEach( listener -> listener.accept( event ) );
    }
}

