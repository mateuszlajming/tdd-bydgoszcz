package g_tdd_solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BracketsChecker {

  public static final char OPENING_SQUARE_BRACKET = '[';

  boolean check(String s) {
    Deque<Character> stack = new LinkedList<>();
    for (char character : s.toCharArray()) {
      if (isOpeningSquareBracket(character)) {
        stack.push(character);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        Character characterFromStack = stack.pop();
        if (!isOpeningSquareBracket(characterFromStack)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isOpeningSquareBracket(char character) {
    return character == OPENING_SQUARE_BRACKET;
  }
}
