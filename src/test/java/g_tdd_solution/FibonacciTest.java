package g_tdd_solution;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

  Fibonacci fibonacci = new Fibonacci();

  @Test
  public void for1_shouldReturn1() {
    int number = fibonacci.fibonacciNumber(1);
    assertThat(number).isEqualTo(1);
  }

  @Test
  public void for2_shouldReturn1() {
    int number = fibonacci.fibonacciNumber(2);
    assertThat(number).isEqualTo(1);
  }

  @Test
  public void for3_shouldReturn2() {
    int number = fibonacci.fibonacciNumber(3);
    assertThat(number).isEqualTo(2);
  }

  @Test
  public void for0_shouldReturn0() {
    int number = fibonacci.fibonacciNumber(0);
    assertThat(number).isEqualTo(0);
  }
}
