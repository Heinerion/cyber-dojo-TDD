package de.hsp.tdd.calc_stats;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StatisticsTest {

  @Test
  void calculates_minimum_value_for_no_input() {
    Statistics calc = Statistics.of();
    assertEquals(Integer.MAX_VALUE, calc.getMinimum());
  }

  @Test
  void calculates_minimum_value_for_single_input() {
    Statistics calc = Statistics.of(1);
    assertEquals(1, calc.getMinimum());
  }

  @Test
  void calculates_minimum_value_for_many_inputs() {
    Statistics calc = Statistics.of(1, -2, 3, -4, 5, -6);
    assertEquals(-6, calc.getMinimum());
  }

  @Test
  void calculates_maximum_value_for_no_input() {
    Statistics calc = Statistics.of();
    assertEquals(Integer.MIN_VALUE, calc.getMaximum());
  }

  @Test
  void calculates_maximum_value_for_single_input() {
    Statistics calc = Statistics.of(1);
    assertEquals(1, calc.getMaximum());
  }
}
