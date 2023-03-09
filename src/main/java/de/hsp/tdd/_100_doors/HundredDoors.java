package de.hsp.tdd._100_doors;

import java.util.*;

public class HundredDoors {
  private static final int MAX_NUMBER = 100;
  private final List<Door> doors;

  public HundredDoors() {
    doors = new ArrayList<>(100);
    for (int i = 1; i <= MAX_NUMBER; i++) {
      doors.add(new Door(i));
    }
  }

  public long countOpenDoors() {
    return doors.stream().filter(Door::isOpen).count();
  }

  public HundredDoors run(int step) {
    for (Door door : doors) {
      if (door.getNumber() % step == 0) {
        door.toggle();
      }
    }
    return this;
  }

  public Collection<Door> getDoors() {
    return doors;
  }
}
