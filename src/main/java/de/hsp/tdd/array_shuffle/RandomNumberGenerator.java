package de.hsp.tdd.array_shuffle;

public class RandomNumberGenerator {
  public int getRandom(int min, int maxExcl) {
    if (maxExcl < min) {
      return getRandom(maxExcl, min);
    }
    return min;
  }
}
