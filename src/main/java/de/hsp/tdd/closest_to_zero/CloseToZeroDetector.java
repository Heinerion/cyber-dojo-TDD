package de.hsp.tdd.closest_to_zero;

import java.util.stream.IntStream;

public class CloseToZeroDetector {
  public int detectClosestNumber(int... numbers) {
    return IntStream
        .of(numbers)
        .min()
        .orElse(Integer.MAX_VALUE);
  }
}
