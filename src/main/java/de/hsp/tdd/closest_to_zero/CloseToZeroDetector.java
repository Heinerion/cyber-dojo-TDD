package de.hsp.tdd.closest_to_zero;

import java.util.stream.IntStream;

public class CloseToZeroDetector {
  public int detectClosestNumber(int... numbers) {
    if (numbers.length == 0) {
      return Integer.MAX_VALUE;
    }
    return IntStream
        .of(numbers)
        .min()
        .orElse(Integer.MAX_VALUE);
  }
}
