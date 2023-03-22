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

  @Test
  void calculates_maximum_value_for_many_inputs() {
    Statistics calc = Statistics.of(1, -2, 3, -4, 5, -6);
    assertEquals(5, calc.getMaximum());
  }

  @Test
  void returns_the_number_of_arguments_for_no_input() {
    int numberOfArguments = Statistics.of().getNumberOfArguments();
    assertEquals(0, numberOfArguments);
  }

  @Test
  void returns_the_number_of_arguments_for_single_input() {
    int numberOfArguments = Statistics.of(1).getNumberOfArguments();
    assertEquals(1, numberOfArguments);
  }

}
