package c_param_solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import a_junit_solution.Calculator;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ParametrizedMethodSourceCalculatorTest {

  Calculator calculator = new Calculator();

  @ParameterizedTest(name = "[{index}]  {0} + {1} = {2}")
  @MethodSource("add")
  public void add(Integer a, Integer b, Integer expectedSum) {
    Integer sum = calculator.add(a, b);

    assertEquals(expectedSum, sum);
  }

  @ParameterizedTest(name = "[{index}]  {0} - {1} = {2}")
  @MethodSource("subtract")
  public void subtract(Integer a, Integer b, Integer expectedDifference) {
    Integer difference = calculator.subtract(a, b);

    assertEquals(expectedDifference, difference);
  }

  @ParameterizedTest(name = "[{index}]  {0} * {1} = {2}")
  @MethodSource("multiply")
  public void multiply(Integer a, Integer b, Integer expectedProduct) {
    Integer product = calculator.multiply(a, b);

    assertEquals(expectedProduct, product);
  }

  @ParameterizedTest(name = "[{index}]  {0} / {1} = {2}")
  @MethodSource("divide")
  public void divide(Integer a, Integer b, Integer expectedQuotient) {
    Integer quotient = calculator.divide(a, b);

    assertEquals(expectedQuotient, quotient);
  }

  static Stream<Arguments> add() {
    return Stream.of(
        Arguments.of(2, 2, 4),
        Arguments.of(1, 3, 4),
        Arguments.of(4, 5, 9));
  }

  static Stream<Arguments> subtract() {
    return Stream.of(
        Arguments.of(2, 2, 0),
        Arguments.of(3, 1, 2),
        Arguments.of(5, 2, 3));
  }

  static Stream<Arguments> multiply() {
    return Stream.of(
        Arguments.of(2, 2, 4),
        Arguments.of(3, 1, 3),
        Arguments.of(5, 2, 10));
  }

  static Stream<Arguments> divide() {
    return Stream.of(
        Arguments.of(2, 2, 1),
        Arguments.of(3, 1, 3),
        Arguments.of(10, 2, 5));
  }
}
