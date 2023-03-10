package de.hsp.tdd.array_shuffle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ArrayShuffleTest {
  @Test
  void random_1_to_2_returns_1_every_time() {
    assertEquals(1, new RandomNumberGenerator().getRandom(1, 2));
  }

  @Test
  void random_2_to_3_returns_2_every_time() {
    assertEquals(2, new RandomNumberGenerator().getRandom(2, 3));
  }

  @Test
  void random_swaps_arguments_if_max_is_less_than_min() {
    assertEquals(2, new RandomNumberGenerator().getRandom(3, 2));
  }

  @Test
  void random_returns_min_if_min_and_max_are_equal() {
    assertEquals(2, new RandomNumberGenerator().getRandom(2, 2));
  }
}
