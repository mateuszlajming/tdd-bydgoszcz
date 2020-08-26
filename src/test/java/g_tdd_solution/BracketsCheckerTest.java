package g_tdd_solution;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BracketsCheckerTest {

  BracketsChecker bracketsChecker;

  @BeforeEach
  public void before() {
    bracketsChecker = new BracketsChecker();
  }

  @ParameterizedTest(name = "{index}: {0} -> {1}")
  @CsvSource({
      "[],true",
      "[][],true",
      "[[]],true",
      "[[[][]]],true",
      "][,false",
      "][][,false",
      "[][]][,false"
  })
  public void check(String s, boolean expected) {
    assertThat(bracketsChecker.check(s)).isEqualTo(expected);
  }
}
