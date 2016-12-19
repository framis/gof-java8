package strategy;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * The intent of the Strategy pattern is generalising a procedure, requiring us to use different but interchangeable algorithms.
 *
 * We are generalising 2 behaviours: the one filtering the text, and the other transforming it.
 */

public class TextEditor {
    public static void publishText( String text, Predicate<String> filter, UnaryOperator<String> format) {
        if (filter.test(text)) {
            System.out.println( format.apply(text) );
        }
    }
}
