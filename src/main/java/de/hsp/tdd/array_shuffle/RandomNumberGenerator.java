package de.hsp.tdd.array_shuffle;

import java.util.Random;

public class RandomNumberGenerator implements RandomNumberStrategy {

  public static final Random RANDOM = new Random();

  @Override
  public int getRandom(int min, int maxExcl) {
    if (maxExcl < min) {
      return getRandom(maxExcl, min);
    }
    if (min == maxExcl) {
      return getRandom(min, min + 1);
    }
    return RANDOM.nextInt(maxExcl - min) + min;
  }
}
