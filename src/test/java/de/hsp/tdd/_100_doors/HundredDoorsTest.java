package de.hsp.tdd._100_doors;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HundredDoorsTest {
  /**
   * 100 doors in a row are all initially closed.
   */
  @Test
  void all_doors_are_initially_closed() {
    HundredDoors hundredDoors = new HundredDoors();
    Collection<Door> doors = hundredDoors.getDoors();

    assertAll(
        () -> assertEquals(0, hundredDoors.countOpenDoors()),
        () -> assertEquals(100, doors.size()),
        () -> assertTrue(doors.stream().noneMatch(Door::isOpen), "each door should be closed")
    );
  }

  /**
   * The first time through, you visit every door and toggle the door (if the door is closed, you open it; if it is
   * open, you close it).
   */
  @Test
  void first_pass_opens_all_100_doors() {
    assertEquals(100, new HundredDoors().run(1).countOpenDoors());
  }

  /**
   * The second time you only visit every 2nd door (door #2, #4, #6, ...).
   */
  @Test
  void second_pass_closes_every_even_door() {
    HundredDoors run = new HundredDoors().run(2);
    Collection<Door> doors = run.getDoors();

    assertAll(
        () -> assertEquals(50, run.countOpenDoors(), "50 doors should be open"),
        () -> assertTrue(doors.stream().filter(d -> d.getNumber() % 2 == 0).noneMatch(Door::isOpen), "each even door should be open"),
        () -> assertTrue(doors.stream().filter(d -> d.getNumber() % 2 != 0).allMatch(Door::isOpen), "each uneven door should be closed")
    );
  }

  /**
   * The third time, every 3rd door (door #3, #6, #9, ...),
   */
  @Test
  void third_pass_toggles_every_third_door() {
    Map<Integer, Boolean> doorsAfterSecondRun = new HundredDoors()
        .run(2)
        .getDoors().stream()
        .collect(Collectors.toMap(Door::getNumber, Door::isOpen));

    Collection<Door> doors = new HundredDoors().run(3).getDoors();

    assertAll(
        () -> assertTrue(doors.stream().filter(d -> d.getNumber() % 3 != 0).allMatch(d -> d.isOpen() == doorsAfterSecondRun.get(d.getNumber())), "No door with a number undivisable by three has been toggled"),
        () -> assertTrue(doors.stream().filter(d -> d.getNumber() % 3 == 0).allMatch(d -> d.isOpen() != doorsAfterSecondRun.get(d.getNumber())), "Every third door has been toggled")
    );
  }
}
