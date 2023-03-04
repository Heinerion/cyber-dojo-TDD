package de.hsp.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppTest {
  @Test
  void greet_returns_Hello_World() {
    assertEquals("Hello World", new App().greet());
  }
}