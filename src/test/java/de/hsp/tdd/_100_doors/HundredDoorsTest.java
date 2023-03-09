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

  /**
   * The first time through, you visit every door and toggle the door (if the door is closed, you open it; if it is
   * open, you close it).
   */
  @Test
  void first_pass_opens_all_100_doors() {
    assertEquals(100, new HundredDoors().run(1).countOpenDoors());
  }
}
