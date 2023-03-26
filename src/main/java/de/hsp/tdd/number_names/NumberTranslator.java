package de.hsp.tdd.number_names;

public class NumberTranslator {

  public String translate(int i) {
    return i < 10
        ? translateDigit(i)
        : translateTens(i);
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
    String text;

    switch (i) {
      case 1:
        text = "one";
        break;
      case 2:
        text = "two";
        break;
      case 3:
        text = "three";
        break;
      case 4:
        text = "four";
        break;
      case 5:
        text = "five";
        break;
      case 6:
        text = "six";
        break;
      case 7:
        text = "seven";
        break;
      case 8:
        text = "eight";
        break;
      case 9:
        text = "nine";
        break;
      default:
        text = "-";
    }

    return text;
  }
}
