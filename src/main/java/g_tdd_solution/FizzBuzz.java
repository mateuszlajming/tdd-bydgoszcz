package g_tdd_solution;

public class FizzBuzz {

  public String fizzBuzz(int number) {
    if(number == 0) {
      return "Other";
    }
    if(number % 3 == 0 && number % 5 == 0) {
      return "FizzBuzz";
    }
    if(number % 3 == 0) {
      return "Fizz";
    }
    if(number % 5 == 0) {
      return "Buzz";
    }
    return "Other";
  }
}

