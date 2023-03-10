package de.hsp.tdd.array_shuffle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ArrayShuffleTest {
  @Test
  void random_1_to_2_returns_1_every_time() {
    assertEquals(1, new RandomNumberGenerator().getRandom(1, 2));
  }
}
