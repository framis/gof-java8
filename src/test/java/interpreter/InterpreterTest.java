package interpreter;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {

    @Test
    public void sampleInterpreterPattern() {
        assertEquals( 12, Interpreter.evaluate("7 3 - 2 1 + *") );
    }
}
