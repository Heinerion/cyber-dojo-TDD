package de.hsp.tdd.array_shuffle;

import java.util.Arrays;

public class Shuffler {
  public <T> T[] shuffle(T[] array) {
    return Arrays.copyOf(array, array.length);
  }
}
