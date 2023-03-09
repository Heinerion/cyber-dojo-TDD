package de.hsp.tdd._100_doors;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HundredDoorsTest {
  /**
   * 100 doors in a row are all initially closed.
   */
  @Test
  void all_doors_are_initially_closed() {
    assertEquals(0, new HundredDoors().countOpenDoors());
  }
}
