package b_exceptions_solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ExceptionsCalculatorTest {

  ExceptionsCalculator exceptionsCalculator = new ExceptionsCalculator();

  @Test
  public void add_whenPassingNullAsTheSecondArgument_shouldThrowIllegalArgumentExceptionWithProperMessage() {
    try {
      exceptionsCalculator.add(1, null);
      fail("Expected IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      assertEquals("null values not allowed", e.getMessage());
    }
  }

  @Test
  public void add_whenPassingNullBothAsTheFirstAndTheSecondArgument_shouldThrowIllegalArgumentExceptionWithProperMessage() {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> exceptionsCalculator.add(null, null));

    assertEquals("null values not allowed", exception.getMessage());
  }

  @Test
  public void divide_whenDividingByZero_shouldThrowIllegalArgumentExceptionWithProperMessage() {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> exceptionsCalculator.divide(1, 0));

    assertEquals("division by 0", exception.getMessage());
  }

}