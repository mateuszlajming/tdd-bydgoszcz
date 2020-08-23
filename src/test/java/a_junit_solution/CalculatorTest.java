package a_junit_solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  Calculator calculator = new Calculator();

  @BeforeAll
  public static void beforeClass() {
    System.out.println("przed wszystkimi");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println("po wszystkich");
  }

  @BeforeEach
  public void before() {
    System.out.println("przed testem");
  }

  @AfterEach
  public void after() {
    System.out.println("po teście");
  }

  @Test
  public void add_whenAdding2Plus2_shouldReturn4() {
    Integer expected = 4;
    assertEquals(expected, calculator.add(2, 2));
  }

  @Test
  public void substract_whenSubstracting6From8_shouldReturn2() {
    Integer expected = 2;
    assertEquals(expected, calculator.subtract(8, 6));
  }

  @Test
  public void multiply_3Times3_shouldReturn9() {
    Integer expected = 9;
    assertEquals(expected, calculator.multiply(3, 3));
  }

  @Disabled
  @Test
  public void divide_divide20By4_shouldReturn5() {
    Integer expected = 5;
    assertEquals(expected, calculator.divide(20, 4));
  }

}
