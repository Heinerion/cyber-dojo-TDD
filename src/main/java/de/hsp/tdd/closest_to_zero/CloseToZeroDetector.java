package de.hsp.tdd.closest_to_zero;

public class CloseToZeroDetector {
  public int detectClosestNumber(int... numbers) {
    int smallest = Integer.MAX_VALUE;
    for (int number : numbers) {
      if (Math.abs(number) < Math.abs(smallest)) {
        smallest = number;
      }
    }
    return smallest;
  }
}
