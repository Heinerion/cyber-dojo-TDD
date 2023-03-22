package de.hsp.tdd.closest_to_zero;

public class CloseToZeroDetector {
  public int detectClosestNumber(int... numbers) {
    int smallest = Integer.MAX_VALUE;
    for (int number : numbers) {
      int distance = Math.abs(number);
      int smallestDistance = Math.abs(smallest);

      // find the closest to zero.
      boolean hasSmallestDistance = distance < smallestDistance;
      // If there is a tie, choose the positive value.
      boolean isPositiveMemberOfATie = distance == smallestDistance
          && number > smallest;

      if (hasSmallestDistance || isPositiveMemberOfATie) {
        smallest = number;
      }
    }
    return smallest;
  }
}
