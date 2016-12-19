package iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The iterator pattern is used to provide a standard interface for traversing a collection of items
 * in an aggregate object without the need to understand its underlying structure.
 */
public class IteratorTest {

    @Test
    public void sampleIterator() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4);
        intList.forEach(System.out::println);
    }

}
