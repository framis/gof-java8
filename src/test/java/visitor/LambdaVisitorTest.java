package visitor;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LambdaVisitorTest {

    @Test
    public void lambdaVisitorTest() {
        List<Object> figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

        double totalArea = figures.stream().map( Utils.areaCalculator ).reduce( 0.0, (v1, v2) -> v1 + v2 );
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = figures.stream().map( Utils.perimeterCalculator ).reduce( 0.0, (v1, v2) -> v1 + v2 );
        System.out.println("Total perimeter = " + totalPerimeter);

        assertEquals(new Double(25), Utils.areaCalculator.apply(new Square(5)));
    }
}
