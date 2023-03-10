package de.hsp.tdd.fizz_buzz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FizzBuzzTest {
  @Test
  void one_renders_as_1() {
    assertEquals("1", new FizzBuzz().render(1));
  }

  @Test
  void two_renders_as_2() {
    assertEquals("2", new FizzBuzz().render(2));
  }

  @Test
  void three_renders_as_Fizz() {
    assertEquals("Fizz", new FizzBuzz().render(3));
  }

  @Test
  void multiples_of_three_render_as_Fizz() {
    assertAll(
        () -> assertEquals("Fizz", new FizzBuzz().render(6)),
        () -> assertEquals("Fizz", new FizzBuzz().render(9))
    );
  }

  @Test
  void five_renders_as_Buzz() {
    assertEquals("Buzz", new FizzBuzz().render(5));
  }
}
