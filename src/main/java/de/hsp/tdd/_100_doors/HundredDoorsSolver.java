package de.hsp.tdd._100_doors;

import java.util.*;

public class HundredDoorsSolver {
  /**
   * <pre>
   * 100 doors in a row are all initially closed. You make 100 passes by the doors. The first time through, you visit every door and toggle the door (if the door is closed, you open it; if it is open, you close it).
   * The second time you only visit every 2nd door (door #2, #4, #6, ...).
   * The third time, every 3rd door (door #3, #6, #9, ...), etc, until you only visit the 100th door.
   *
   * Question: What state are the doors in after the last pass? Which are open, which are closed?
   *
   * [Source http://rosettacode.org]
   * </pre>
   */
  public static void main(String... args) {
    HundredDoors run = new HundredDoors().run(100);
    long openDoorCount = run.countOpenDoors();

    List<String> openDoors = new ArrayList<>();
    List<String> closedDoors = new ArrayList<>();
    for (Door door : run.getDoors()) {
      if (door.isOpen()) {
        openDoors.add(stringify(door));
      } else {
        closedDoors.add(stringify(door));
      }
    }

    // Question: What state are the doors in after the last pass? Which are open, which are closed?
    System.out.printf(
        "After one hundred passes, %d doors are open.%n"
            + "Open doors:    %s%n"
            + "Closed doors:  %s%n",
        openDoorCount,
        String.join(", ", openDoors),
        String.join(", ", closedDoors));
  }

  private static String stringify(Door door) {
    return String.format("%03d", door.getNumber());
  }
}
