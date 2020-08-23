package c_param_solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import a_junit_solution.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ParametrizedArgumentsSourceCalculatorTest {

  Calculator calculator = new Calculator();

  @ParameterizedTest(name = "[{index}]  {0} + {1} = {2}")
  @ArgumentsSource(AddDataProvider.class)
  public void add(Integer a, Integer b, Integer expectedSum) {
    Integer sum = calculator.add(a, b);

    assertEquals(expectedSum, sum);
  }

  @ParameterizedTest(name = "[{index}]  {0} - {1} = {2}")
  @ArgumentsSource(SubtractDataProvider.class)
  public void subtract(Integer a, Integer b, Integer expectedDifference) {
    Integer difference = calculator.subtract(a, b);

    assertEquals(expectedDifference, difference);
  }

  @ParameterizedTest(name = "[{index}]  {0} * {1} = {2}")
  @ArgumentsSource(MultiplyDataProvider.class)
  public void multiply(Integer a, Integer b, Integer expectedProduct) {
    Integer product = calculator.multiply(a, b);

    assertEquals(expectedProduct, product);
  }

  @ParameterizedTest(name = "[{index}]  {0} / {1} = {2}")
  @ArgumentsSource(DivideDataProvider.class)
  public void divide(Integer a, Integer b, Integer expectedQuotient) {
    Integer quotient = calculator.divide(a, b);

    assertEquals(expectedQuotient, quotient);
  }

}
