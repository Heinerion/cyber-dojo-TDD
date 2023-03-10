package de.hsp.tdd.fizz_buzz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FizzBuzzTest {
  @Test
  void one_renders_as_1() {
    assertEquals("1", new FizzBuzz().render(1));
  }
}
