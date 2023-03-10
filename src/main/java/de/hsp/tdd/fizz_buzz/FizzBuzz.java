package de.hsp.tdd.fizz_buzz;

public class FizzBuzz {
  public String render(int number) {
    String rendered = "";
    if (number % 3 == 0) {
      rendered += "Fizz";
    }
    if (number % 5 == 0) {
      rendered += "Buzz";
    }
    
    return rendered.isBlank()
        ? String.valueOf(number)
        : rendered;
  }
}
