package de.hsp.tdd.align_columns;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AlignColumnsTest {

  @Test
  void words_in_each_column_are_separated_by_at_least_one_space() {
    String formatted = new AlignColumns().align("three$simple$words");
    String[] tokens = formatted.split("\\s+");
    assertArrayEquals(new String[]{"three", "simple", "words"}, tokens);
  }

  @Test
  void input_texts_lines_may_or_may_not_have_trailing_dollar_characters() {
    String trimmed = new AlignColumns().align("three$simple$words");
    String trailing = new AlignColumns().align("three$simple$words$");
    assertEquals(trimmed, trailing);
  }

  @Test
  void aligns_columns_of_fields_in_multiple_lines() {
    String originalText = ""
        + "line$number$one\n"
        + "second$line$two";

    String expected = ""
        + "line   number one\n"
        + "second line   two";

    String formatted = new AlignColumns().align(originalText);
    assertEquals(expected, formatted);
  }
}
