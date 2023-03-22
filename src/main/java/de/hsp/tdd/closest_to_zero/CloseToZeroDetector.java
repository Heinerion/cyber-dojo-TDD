package de.hsp.tdd.closest_to_zero;

public class CloseToZeroDetector {
  public int detectClosestNumber(int... numbers) {
    int smallest = Integer.MAX_VALUE;
    for (int number : numbers) {
      int distance = Math.abs(number);
      int smallestDistance = Math.abs(smallest);
      if (distance < smallestDistance) {
        smallest = number;
      } else if (distance == smallestDistance
          // If the distance to zero is equal, choose the positive value
          && number > smallest) {
        smallest = number;
      }
    }
    return smallest;
  }
}
