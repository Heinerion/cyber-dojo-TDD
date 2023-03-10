package de.hsp.tdd.fizz_buzz;

public class FizzBuzz {
  public String render(int number) {
    if (number % 3 == 0) {
      return "Fizz";
    }
    if (number % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(number);
  }
}
