package de.hsp.tdd._100_doors;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

  public HundredDoors run(int numberOfPasses) {
    for (int i = 1; i <= numberOfPasses; i++) {
      pass(i);
    }
    return this;
  }

  private void pass(int step) {
    for (Door door : doors) {
      if (door.getNumber() % step == 0) {
        door.toggle();
      }
    }
  }

  public Collection<Door> getDoors() {
    return Collections.unmodifiableList(doors);
  }

  public Collection<Door> getDoors(Predicate<Door> filter) {
    return doors.stream().filter(filter).collect(Collectors.toList());
  }

}
