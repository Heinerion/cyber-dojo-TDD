package de.hsp.tdd.number_names;

public class NumberTranslator {

  private static final String EMPTY = "";
  private static final String[] DIGITS = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
  private static final String[] MAGNITUDES = new String[]{EMPTY, "thousand", "million", "billion", "trillion"};

  private long rest = 0;
  private int magnitude = 0;

  public String translate(long i) {
    if (i == 0) {
      return "zero";
    }

    this.rest = i;

    String text = "";
    while (rest > 0) {
      text = translateMagnitude(text);
      this.magnitude++;
      this.rest /= 1_000;
    }

    return text;
  }

  private String translateMagnitude(String trailingText) {
    String text = translateSmallNumbers((int) (rest % 1_000));
    String nameOfMagnitude = MAGNITUDES[this.magnitude];
    if (!nameOfMagnitude.equals(EMPTY)) {
      text += String.format(" %s, %s", nameOfMagnitude, trailingText);
    }
    return text;
  }

  /**
   * translates positive numbers up to 999
   *
   * @param i
   *     number between 0 and 999
   *
   * @return the textual representation of the number
   */
  private String translateSmallNumbers(int i) {
    if (i < 10) {
      return translateDigit(i);
    }
    if (i < 20) {
      return translateTens(i);
    }
    if (i < 100) {
      return translateTwoDigitNumbers(i);
    }
    return translateThreeDigits(i);
  }

  private String translateThreeDigits(int i) {
    String text = translateDigit(i / 100) + " hundred";
    if (i % 100 != 0) {
      text += String.format(" and %s", translateSmallNumbers(i % 100));
    }
    return text;
  }

  private String translateTwoDigitNumbers(int i) {
    String number = translatePowerOfTen(i / 10);
    if (i % 10 != 0) {
      number += String.format(" %s", translateDigit(i % 10));
    }
    return number;
  }

  private String translatePowerOfTen(int i) {
    switch (i) {
      case 2:
        return "twenty";
      case 3:
        return "thirty";
      case 4:
        return "forty";
      case 5:
        return "fifty";
      case 8:
        return "eighty";
      default:
        return translateDigit(i) + "ty";
    }
  }

  private String translateTens(int i) {
    switch (i % 10) {
      case 0:
        return "ten";
      case 1:
        return "eleven";
      case 2:
        return "twelve";
      case 3:
        return "thirteen";
      case 5:
        return "fifteen";
      case 8:
        return "eighteen";
      default:
        return translateDigit(i % 10) + "teen";
    }
  }

  private String translateDigit(int i) {
    return DIGITS[i];
  }
}
