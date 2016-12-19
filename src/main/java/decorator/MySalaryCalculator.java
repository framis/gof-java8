package decorator;

import java.util.function.DoubleUnaryOperator;

/**
 * Wikipedia: the decorator pattern is a design pattern that allows behavior to be added to an individual object,
 * either statically or dynamically, without affecting the behavior of other objects from the same class.
 * The decorator pattern is often useful for adhering to the Single Responsibility Principle,
 * as it allows functionality to be divided between classes with unique areas of concern.
 * See: https://www.voxxed.com/blog/2016/05/gang-four-patterns-functional-light-part-3/
 *
 * The functional interface avoids the ugly:
 * double netSalary = new HealthInsuranceDecorator(
         new RegionalTaxDecorator(
            new GeneralTaxDecorator(
                new DefaultSalaryCalculator()
            )
         )
    ).calculate( 30000.00 ));
 */
public class MySalaryCalculator implements DoubleUnaryOperator {

    @Override
    public double applyAsDouble(double grossAnnual) {
        return grossAnnual / 12;
    }


}
