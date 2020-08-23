package b_exceptions_solution;

public class ExceptionsCalculator {

  public Integer add(Integer a, Integer b) {
    checkForNullValues(a, b);
    return a + b;
  }

  public Integer subtract(Integer a, Integer b) {
    checkForNullValues(a, b);
    return a - b;
  }

  public Integer multiply(Integer a, Integer b) {
    checkForNullValues(a, b);
    return a * b;
  }

  public Integer divide(Integer a, Integer b) {
    checkForNullValues(a, b);
    if (b == 0) {
      throw new IllegalArgumentException("division by 0");
    }
    return a / b;
  }

  private void checkForNullValues(Integer a, Integer b) {
    if (a == null || b == null) {
      throw new IllegalArgumentException("null values not allowed");
    }
  }
}
