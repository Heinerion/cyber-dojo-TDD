package de.hsp.tdd.fizz_buzz;

public class FizzBuzz {
  public String render(int number) {
    if (number % 3 == 0) {
      return "Fizz";
    }
    return String.valueOf(number);
  }
}
