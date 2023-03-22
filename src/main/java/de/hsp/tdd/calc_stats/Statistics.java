package de.hsp.tdd.calc_stats;

public final class Statistics {

  private Statistics() {
    // hide default constructor
  }

  public static Statistics of(int i) {
    return new Statistics();
  }

  public int getMinimum() {
    return 1;
  }
}
