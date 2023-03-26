package de.hsp.tdd.number_names;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberTranslatorTest {
  @Test
  void translates_1_to_one() {
    assertEquals("one", new NumberTranslator().translate(1));
  }
}
