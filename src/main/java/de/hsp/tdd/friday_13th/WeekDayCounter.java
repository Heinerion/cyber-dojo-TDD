package de.hsp.tdd.friday_13th;

import java.time.*;
import java.util.*;

public class WeekDayCounter {

  public WeekDayCounter(LocalDate startDate, LocalDate endDate) {
  }

  public Map<DayOfWeek, Long> countWeekDaysForDayInMonth(int i) {
    return Collections.singletonMap(DayOfWeek.MONDAY, 1L);
  }

}
