package visitor;

import java.util.function.Function;

public class Utils {

    static Function<Object, Double> areaCalculator = new LambdaVisitor<Double>()
            .on(Square.class).then( s -> s.side * s.side )
            .on(Circle.class).then( c -> Math.PI * c.radius * c.radius )
            .on(Rectangle.class).then( r -> r.height * r.width );

    static Function<Object, Double> perimeterCalculator = new LambdaVisitor<Double>()
            .on(Square.class).then( s -> 4 * s.side )
            .on(Circle.class).then( c -> 2 * Math.PI * c.radius )
            .on(Rectangle.class).then( r -> 2 * r.height + 2 * r.width );
}
