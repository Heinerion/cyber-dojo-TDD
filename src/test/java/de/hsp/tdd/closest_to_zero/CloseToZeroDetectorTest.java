package de.hsp.tdd.closest_to_zero;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CloseToZeroDetectorTest {
  @Test
  void detect_smallest_distance_to_zero_for_no_arguments() {
    int closest = new CloseToZeroDetector().detectClosestNumber();
    assertEquals(Integer.MAX_VALUE, closest);
  }

  @Test
  void detect_smallest_distance_to_zero_for_single_arguments() {
    int closest = new CloseToZeroDetector().detectClosestNumber(1);
    assertEquals(1, closest);
  }

  @Test
  void detect_smallest_distance_to_zero_for_positive_arguments() {
    int closest = new CloseToZeroDetector().detectClosestNumber(7, 2, 13, 1);
    assertEquals(1, closest);
  }

  @Test
  void detect_smallest_distance_to_zero_for_negative_arguments() {
    int closest = new CloseToZeroDetector().detectClosestNumber(-7, -2, -13, -1);
    assertEquals(-1, closest);
  }

  @Test
  void detect_smallest_distance_to_zero_for_alternating_arguments() {
    int closest = new CloseToZeroDetector().detectClosestNumber(7, -2, 13, -1);
    assertEquals(-1, closest);
  }

  @Test
  void treat_positive_numbers_as_closer_to_zero() {
    int closest = new CloseToZeroDetector().detectClosestNumber(-1, 1, -1);
    assertEquals(1, closest);

    // second check: make sure, that the order of the arguments has no effect
    closest = new CloseToZeroDetector().detectClosestNumber(1, -1, 1);
    assertEquals(1, closest);
  }
}
