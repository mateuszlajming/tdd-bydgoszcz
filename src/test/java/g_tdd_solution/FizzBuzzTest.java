package g_tdd_solution;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

  FizzBuzz fizzBuzz = new FizzBuzz();

  @Test
  public void fizzBuzz_for3_shouldReturnFizz() {
    String returned = fizzBuzz.fizzBuzz(3);
    assertThat(returned).isEqualTo("Fizz");
  }

  @Test
  public void fizzBuzz_for5_shouldReturnBuzz() {
    String returned = fizzBuzz.fizzBuzz(5);
    assertThat(returned).isEqualTo("Buzz");
  }

  @Test
  public void fizzBuzz_for6_shouldReturnFizz() {
    String returned = fizzBuzz.fizzBuzz(6);
    assertThat(returned).isEqualTo("Fizz");
  }

  @Test
  public void fizzBuzz_for10_shouldReturnBuzz() {
    String returned = fizzBuzz.fizzBuzz(10);
    assertThat(returned).isEqualTo("Buzz");
  }

  @Test
  public void fizzBuzz_for15_shouldReturnFizzBuzz() {
    String returned = fizzBuzz.fizzBuzz(15);
    assertThat(returned).isEqualTo("FizzBuzz");
  }

  @Test
  public void fizzBuzz_for30_shouldReturnFizzBuzz() {
    String returned = fizzBuzz.fizzBuzz(30);
    assertThat(returned).isEqualTo("FizzBuzz");
  }

  @Test
  public void fizzBuzz_for0_shouldReturnOther() {
    String returned = fizzBuzz.fizzBuzz(0);
    assertThat(returned).isEqualTo("Other");
  }

  @Test
  public void fizzBuzz_for2_shouldReturnOther() {
    String returned = fizzBuzz.fizzBuzz(2);
    assertThat(returned).isEqualTo("Other");
  }
}
