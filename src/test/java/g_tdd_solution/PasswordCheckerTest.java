package g_tdd_solution;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PasswordCheckerTest {

  PasswordChecker passwordChecker = new PasswordChecker();

  @ParameterizedTest
  @CsvSource({
      "a,false",
      "sdfghjkl,false",
      "Sdfghjkl,false",
      "asdfjkl1,false",
      "Asdfjkl1,false",
      "Asdfjkl1!,true",
      "Asdfjkl1@,true",
      "Asdfjkl1#,true",
      "Asdfjkl1$,true",
      "Asdfjkl1%,true",
      "Asdfjkl1&,true",
      "Asdfjkl1*,true",
  })
  public void checkPassword(String password, boolean expected) {
    assertThat(passwordChecker.checkPassword(password)).isEqualTo(expected);
  }
}
