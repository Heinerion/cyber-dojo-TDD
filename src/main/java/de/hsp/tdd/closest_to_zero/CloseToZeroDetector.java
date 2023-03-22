package de.hsp.tdd.closest_to_zero;

public class CloseToZeroDetector {
  public int detectClosestNumber(int... numbers) {
    if (numbers.length == 0) {
      return Integer.MAX_VALUE;
    }
    return numbers[0];
  }
}
