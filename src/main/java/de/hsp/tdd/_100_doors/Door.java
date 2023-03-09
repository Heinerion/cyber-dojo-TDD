package de.hsp.tdd._100_doors;

public class Door {
  private final int number;
  private boolean open = false;

  public Door(int number) {
    this.number = number;
  }

  int getNumber() {
    return number;
  }

  boolean isOpen() {
    return open;
  }

  public void toggle() {
    open = !open;
  }

  @Override
  public String toString() {
    return String.format("%03d", number);
  }
}
