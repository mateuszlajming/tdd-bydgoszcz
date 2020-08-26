package g_tdd_solution;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LeapYearCheckerTest {

  LeapYearChecker leapYearChecker = new LeapYearChecker();

  @Test
  public void isLeapYear_whenPassing2008WhichIsDivisibleBy4ButNotBy100_shouldReturnTrue() {
    assertThat(leapYearChecker.isLeapYear(2008)).isTrue();
  }

  @Test
  public void isLeapYear_whenPassing2000WhichIsDivisibleBy400_shouldReturnTrue() {
    assertThat(leapYearChecker.isLeapYear(2000)).isTrue();
  }

  @Test
  public void isLeapYear_whenPassing2100WhichIsDivisibleBy4ButAlsoIsDivisibleBy100_shouldReturnFalse() {
    assertThat(leapYearChecker.isLeapYear(2100)).isFalse();
  }

  @Test
  public void isLeapYear_whenPassing2007WhichIsNotDivisibleBy4Or400_shouldReturnFalse() {
    assertThat(leapYearChecker.isLeapYear(2007)).isFalse();
  }
}
