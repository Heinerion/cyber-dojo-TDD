package de.hsp.tdd.number_names;

public class NumberTranslator {

  public String translate(int i) {
    String text = "";

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
    }

    return text;
  }
}
