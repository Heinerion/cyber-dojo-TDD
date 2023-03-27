package de.hsp.tdd.number_names;

public class NumberTranslator {

  private static final String[] DIGITS = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

  public String translate(int i) {
    String text;

    if (i < 1_000) {
      text = translateSmallNumbers(i);
    } else {
      text = translate(i / 1_000) + " thousand, "
          + translateSmallNumbers(i % 1_000);
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
      text += " and " + translate(i % 100);
    }
    return text;
  }

  private String translateTwoDigitNumbers(int i) {
    String number = translatePowerOfTen(i / 10 * 10);
    if (i % 10 != 0) {
      number += " " + translateDigit(i % 10);
    }
    return number;
  }

  private String translatePowerOfTen(int i) {
    String text;
    switch (i) {
      case 20:
        text = "twenty";
        break;
      case 30:
        text = "thirty";
        break;
      case 40:
        text = "forty";
        break;
      case 50:
        text = "fifty";
        break;
      case 80:
        text = "eighty";
        break;
      default:
        text = translateDigit(i / 10) + "ty";
    }
    return text;
  }

  private String translateTens(int i) {
    String text;

    switch (i) {
      case 10:
        text = "ten";
        break;
      case 11:
        text = "eleven";
        break;
      case 12:
        text = "twelve";
        break;
      case 13:
        text = "thirteen";
        break;
      case 15:
        text = "fifteen";
        break;
      case 18:
        text = "eighteen";
        break;
      default:
        text = translateDigit(i % 10) + "teen";
    }

    return text;
  }

  private String translateDigit(int i) {
    return DIGITS[i];
  }
}
