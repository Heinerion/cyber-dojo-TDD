package de.hsp.tdd.align_columns;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AlignColumnsTest {

  @Test
  void words_in_each_column_are_separated_by_at_least_one_space() {
    String formatted = new AlignColunms().align("three$simple$words");
    String[] tokens = formatted.split("\\s+");
    assertArrayEquals(new String[]{"three", "simple", "words"}, tokens);
  }
}
