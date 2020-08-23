package c_param_solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import a_junit_solution.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParametrizedCsvSourceCalculatorTest {

  Calculator calculator = new Calculator();

  @ParameterizedTest(name = "[{index}]  {0} + {1} = {2}")
  @CsvSource({
      "2,2,4",
      "1,3,4",
      "4,5,9"})
  public void add(Integer a, Integer b, Integer expectedSum) {
    Integer sum = calculator.add(a, b);

    assertEquals(expectedSum, sum);
  }

  @ParameterizedTest(name = "[{index}]  {0} - {1} = {2}")
  @CsvSource({
      "2, 2, 0",
      "3, 1, 2",
      "5, 2, 3"})
  public void subtract(Integer a, Integer b, Integer expectedDifference) {
    Integer difference = calculator.subtract(a, b);

    assertEquals(expectedDifference, difference);
  }

  @ParameterizedTest(name = "[{index}]  {0} * {1} = {2}")
  @CsvSource({
      "2, 2, 4",
      "3, 1, 3",
      "5, 2, 10"})
  public void multiply(Integer a, Integer b, Integer expectedProduct) {
    Integer product = calculator.multiply(a, b);

    assertEquals(expectedProduct, product);
  }

  @ParameterizedTest(name = "[{index}]  {0} / {1} = {2}")
  @CsvSource({
      "2, 2, 1",
      "3, 1, 3",
      "10, 2, 5"})
  public void divide(Integer a, Integer b, Integer expectedQuotient) {
    Integer quotient = calculator.divide(a, b);

    assertEquals(expectedQuotient, quotient);
  }

}
