package de.hsp.tdd.fizz_buzz;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;

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

  @Test
  void multiples_of_five_render_as_Buzz() {
    assertAll(
        () -> assertEquals("Buzz", new FizzBuzz().render(10)),
        () -> assertEquals("Buzz", new FizzBuzz().render(25))
    );
  }

  @Test
  void multiples_of_three_and_five_render_as_FizzBuzz() {
    assertAll(
        () -> assertEquals("FizzBuzz", new FizzBuzz().render(15)),
        () -> assertEquals("FizzBuzz", new FizzBuzz().render(30))
    );
  }

  @Test
  void print_displays_exactly_100_Strings() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    new FizzBuzz().print(outputStream);

    assertEquals(100, outputStream.toString().split("[\\r\\n]+").length);
  }
}
