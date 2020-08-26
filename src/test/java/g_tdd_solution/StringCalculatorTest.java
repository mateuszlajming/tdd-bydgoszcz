package g_tdd_solution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  StringCalculator stringCalculator = new StringCalculator();

  @Test
  public void add_whenPassingNull_shouldThrowIllegalArgumentException_withMessageNullNotAllowed() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
          stringCalculator.add(null);
        }).withMessage("null not allowed");
  }

  @Test
  public void add_whenPassingEmptyString_shouldReturn0() {
    assertThat(stringCalculator.add("")).isEqualTo(0);
  }

  @Test
  public void add_whenPassingTwoNumbersSeparatedByAComma_shouldReturnTheSumOfThoseNumbers() {
    assertThat(stringCalculator.add("2,3")).isEqualTo(5);
  }

  @Test
  public void add_whenPassingMoreThanTwoNumbersSeparatedByAComma_shouldReturnTheSumOfThoseNumbers() {
    assertThat(stringCalculator.add("2,3,4")).isEqualTo(9);
  }

  @Test
  public void add_whenUsingNewLineCharacterAsASeparator_shouldStillReturnTheSumOfPassedNumbers() {
    assertThat(stringCalculator.add("2\n3\n4")).isEqualTo(9);
  }

  @Test
  public void add_whenUsingSemicolonAsASeparator_shouldStillReturnTheSumOfPassedNumbers() {
    assertThat(stringCalculator.add("2;3;4")).isEqualTo(9);
  }

  @Test
  public void add_whenUsingFewDifferentTypesOfSeparatorsAtOnce_shouldStillReturnTheSumOfPassedNumbers() {
    assertThat(stringCalculator.add("2,3;4\n1")).isEqualTo(10);
  }

  @Test
  public void add_whenPassingNegativeNumber_shouldThrowIllegalArgumentException_withMessageNegativesNotAllowed() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
          stringCalculator.add("-1,2");
        }).withMessage("negatives not allowed: -1");
  }

  @Test
  public void add_whenPassingNumbersGreaterThan1000_numbersGreaterThan1000ShouldBeIgnored() {
    assertThat(stringCalculator.add("2,3,1001")).isEqualTo(5);
  }

  @Test
  public void add_whenDefiningSingleCharSeparator_itShouldBeUsed() {
    assertThat(stringCalculator.add("//#\n2#3")).isEqualTo(5);
  }

}
