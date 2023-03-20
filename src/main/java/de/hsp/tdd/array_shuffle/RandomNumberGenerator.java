package de.hsp.tdd.array_shuffle;

import java.util.Random;

public class RandomNumberGenerator implements RandomNumberStrategy {

  public static final Random RANDOM = new Random();

  @Override
  public int getRandom(int min, int maxExcl) {
    int difference = Math.abs(min - maxExcl);
    return RANDOM.nextInt(difference != 0 ? difference : 1) + Math.min(min, maxExcl);
  }
}
