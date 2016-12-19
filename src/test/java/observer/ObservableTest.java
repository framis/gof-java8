package observer;

import org.junit.Test;

public class ObservableTest {
    @Test
    public void sampleObserverPattern() {
        Observable observable = new Observable();
        observable.register( "key1", e -> System.out.println(e) );
        observable.register( "key2", System.out::println );
        observable.sendEvent( "Hello World!" );
    }
}
