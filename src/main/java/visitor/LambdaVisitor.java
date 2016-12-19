package visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The visitor pattern is used to separate a relatively complex set of structured data classes
 * from the functionality that may be performed upon the data that they hold.
 *
 * The functional implementation uses pattern matching.
 */
public class LambdaVisitor<A> implements Function<Object, A> {
    private Map<Class<?>, Function<Object, A>> fMap = new HashMap<>();

    public <B> Acceptor<A, B> on(Class<B> clazz) {
        return new Acceptor<>(this, clazz);
    }

    @Override
    public A apply( Object o ) {
        return fMap.get(o.getClass()).apply( o );
    }

    static class Acceptor<A, B> {
        private final LambdaVisitor visitor;
        private final Class<B> clazz;

        Acceptor( LambdaVisitor<A> visitor, Class<B> clazz ) {
            this.visitor = visitor;
            this.clazz = clazz;
        }

        public LambdaVisitor<A> then(Function<B, A> f) {
            visitor.fMap.put( clazz, f );
            return visitor;
        }
    }
}
