package de.hsp.tdd.friday_13th;

import java.time.*;
import java.util.*;

public class WeekDayCounter {

  private final LocalDate startDate;

  private final LocalDate endDate;

  public WeekDayCounter(LocalDate startDate, LocalDate endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Map<DayOfWeek, Long> countWeekDaysForDayInMonth(int i) {
    LocalDate workingDate = startDate;

    EnumMap<DayOfWeek, Long> occurrences = new EnumMap<>(DayOfWeek.class);

    while (!workingDate.isAfter(endDate)) {
      if (workingDate.getDayOfMonth() == i) {
        occurrences.compute(workingDate.getDayOfWeek(), (d, l) -> l == null ? 1 : l + 1);
      }
      workingDate = workingDate.plusDays(1);
    }

    return occurrences;
  }

}
