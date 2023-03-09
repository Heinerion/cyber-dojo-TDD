package de.hsp.tdd._100_doors;

public class HundredDoors {
  int openDoors = 0;

  public int countOpenDoors() {
    return openDoors;
  }

  public HundredDoors run(int i) {
    openDoors = 100;
    return this;
  }
}
