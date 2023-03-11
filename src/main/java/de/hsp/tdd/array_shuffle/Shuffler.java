package de.hsp.tdd.array_shuffle;

import java.util.Arrays;

public class Shuffler {
  private final RandomNumberStrategy strategy;

  public Shuffler(RandomNumberStrategy strategy) {
    this.strategy = strategy;
  }

  public <T> T[] shuffle(T[] array) {
    T[] workingCopy = copy(array);

    // > Iterate through the array and for each element[i]
    int length = workingCopy.length;
    for (int i = 0; i < length; i++) {
      // > generate a random integer (min=r,max=array.size)
      // remark: as r is not yet defined, I use min=i
      int r = strategy.getRandom(i, length);

      // > swap the integers at indexes i and r
      T oldI = workingCopy[i];
      T oldR = workingCopy[r];

      workingCopy[i] = oldR;
      workingCopy[r] = oldI;
    }
    return copy(workingCopy);
  }

  private static <U> U[] copy(U[] original) {
    return Arrays.copyOf(original, original.length);
  }
}
