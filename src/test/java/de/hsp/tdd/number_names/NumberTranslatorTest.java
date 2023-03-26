package de.hsp.tdd.number_names;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberTranslatorTest {
  @Test
  void translates_1() {
    assertEquals("one", new NumberTranslator().translate(1));
  }

  @Test
  void translates_2() {
    assertEquals("two", new NumberTranslator().translate(2));
  }

  @Test
  void translates_3() {
    assertEquals("three", new NumberTranslator().translate(3));
  }

  @Test
  void translates_4() {
    assertEquals("four", new NumberTranslator().translate(4));
  }

  @Test
  void translates_5() {
    assertEquals("five", new NumberTranslator().translate(5));
  }

  @Test
  void translates_6() {
    assertEquals("six", new NumberTranslator().translate(6));
  }

  @Test
  void translates_7() {
    assertEquals("seven", new NumberTranslator().translate(7));
  }

  @Test
  void translates_8() {
    assertEquals("eight", new NumberTranslator().translate(8));
  }

  @Test
  void translates_9() {
    assertEquals("nine", new NumberTranslator().translate(9));
  }

  @Test
  void translates_10() {
    assertEquals("ten", new NumberTranslator().translate(10));
  }

  @Test
  void translates_11() {
    assertEquals("eleven", new NumberTranslator().translate(11));
  }

  @Test
  void translates_12() {
    assertEquals("twelve", new NumberTranslator().translate(12));
  }

  @Test
  void translates_13() {
    assertEquals("thirteen", new NumberTranslator().translate(13));
  }

  @Test
  void translates_14() {
    assertEquals("fourteen", new NumberTranslator().translate(14));
  }

  @Test
  void translates_15() {
    assertEquals("fifteen", new NumberTranslator().translate(15));
  }

  @Test
  void translates_16() {
    assertEquals("sixteen", new NumberTranslator().translate(16));
  }

  @Test
  void translates_17() {
    assertEquals("seventeen", new NumberTranslator().translate(17));
  }

  @Test
  void translates_18() {
    assertEquals("eighteen", new NumberTranslator().translate(18));
  }

  @Test
  void translates_19() {
    assertEquals("nineteen", new NumberTranslator().translate(19));
  }
}
