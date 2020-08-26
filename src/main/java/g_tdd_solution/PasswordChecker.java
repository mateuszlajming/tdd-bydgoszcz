package g_tdd_solution;

public class PasswordChecker {

  public static final int MINIMUM_PASS_LENGTH = 8;

  boolean checkPassword(String password) {
    return haveAtLeast8Characters(password)
        && hasAtLeastOneUppercaseLetter(password)
        && hasAtLeastOneDigit(password)
        && hasAtLeastOneSpecialCharacter(password);
  }

  private boolean haveAtLeast8Characters(String password) {
    return password.length() >= MINIMUM_PASS_LENGTH;
  }

  private boolean hasAtLeastOneUppercaseLetter(String password) {
    return password.matches(".*[A-Z].*");
  }

  private boolean hasAtLeastOneDigit(String password) {
    return password.matches(".*[0-9].*");
  }

  private boolean hasAtLeastOneSpecialCharacter(String password) {
    return password.matches(".*[!@#$%&*]");
  }
}
