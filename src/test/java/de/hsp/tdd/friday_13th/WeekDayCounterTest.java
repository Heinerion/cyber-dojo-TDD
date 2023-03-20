package de.hsp.tdd.friday_13th;

import org.junit.jupiter.api.*;

import java.time.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WeekDayCounterTest {

  @Test
  void the_1st_of_January_1973_was_a_Monday() {
    LocalDate date = LocalDate.of(1973, 1, 1);
    Map<DayOfWeek, Long> occurrences = new WeekDayCounter(date, date)
        .countWeekDaysForDayInMonth(1);
    assertEquals(Long.valueOf(1), occurrences.get(DayOfWeek.MONDAY));
  }

  @Test
  void the_13th_of_January_1973_was_a_Saturday() {
    Map<DayOfWeek, Long> occurrences = new WeekDayCounter(
        LocalDate.of(1973, 1, 1),
        LocalDate.of(1973, 1, 31))
        .countWeekDaysForDayInMonth(13);
    assertEquals(Long.valueOf(1), occurrences.get(DayOfWeek.SATURDAY));
  }
}
