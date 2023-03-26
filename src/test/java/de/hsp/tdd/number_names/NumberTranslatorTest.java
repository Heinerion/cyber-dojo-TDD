package de.hsp.tdd.number_names;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberTranslatorTest {
  @Test
  void translates_1_to_one() {
    assertEquals("one", new NumberTranslator().translate(1));
  }

  @Test
  void translates_2_to_two() {
    assertEquals("two", new NumberTranslator().translate(2));
  }

  @Test
  void translates_3_to_three() {
    assertEquals("three", new NumberTranslator().translate(3));
  }

  @Test
  void translates_4_to_four() {
    assertEquals("four", new NumberTranslator().translate(4));
  }

  @Test
  void translates_5_to_five() {
    assertEquals("five", new NumberTranslator().translate(5));
  }

  @Test
  void translates_6_to_six() {
    assertEquals("six", new NumberTranslator().translate(6));
  }

  @Test
  void translates_7_to_seven() {
    assertEquals("seven", new NumberTranslator().translate(7));
  }

  @Test
  void translates_8_to_eight() {
    assertEquals("eight", new NumberTranslator().translate(8));
  }

  @Test
  void translates_9_to_nine() {
    assertEquals("nine", new NumberTranslator().translate(9));
  }

}
