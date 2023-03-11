package de.hsp.tdd.array_shuffle;

import java.util.Arrays;

public class Shuffler {
  public <T> T[] shuffle(T[] array) {
    T[] workingCopy = copy(array);
    workingCopy[0] = array[array.length - 1];
    workingCopy[array.length - 1] = array[0];
    return copy(workingCopy);
  }

  private static <U> U[] copy(U[] original) {
    return Arrays.copyOf(original, original.length);
  }
}
