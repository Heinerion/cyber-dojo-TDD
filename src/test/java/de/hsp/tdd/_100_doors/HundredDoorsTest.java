package de.hsp.tdd._100_doors;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HundredDoorsTest {
  @Test
  void all_doors_are_initially_closed() {
    assertEquals(0, new HundredDoors().countOpenDoors());
  }
}
