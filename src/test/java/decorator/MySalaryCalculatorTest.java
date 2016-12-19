package decorator;

import org.junit.Test;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

public class MySalaryCalculatorTest {

    @Test
    public void sampleDecoratorPattern() {
        double netSalary = new MySalaryCalculator()
                .andThen( Taxes::generalTax )
                .andThen( Taxes::regionalTax )
                .andThen( Taxes::healthInsurance )
                .applyAsDouble( 30000.00 );

        System.out.printf("Salary: %s\n", netSalary);
    }

    @Test
    public void sampleDecoratorPatternConsise() {

        double netSalary = calculate(30000.00,
                new MySalaryCalculator(),
                Taxes::generalTax,
                Taxes::regionalTax,
                Taxes::healthInsurance);

        System.out.printf("Salary: %s\n", netSalary);
    }

    public static double calculate(double gross, DoubleUnaryOperator... fs) {
        return Stream.of(fs)
                .reduce( DoubleUnaryOperator.identity(),
                        DoubleUnaryOperator::andThen )
                .applyAsDouble( gross );
    }
}
