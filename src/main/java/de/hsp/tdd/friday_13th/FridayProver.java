package de.hsp.tdd.friday_13th;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class FridayProver {
  public static void main(String[] args) {
    LocalDate startDate = LocalDate.of(0, 1, 1);
    LocalDate endDate = LocalDate.of(2030, 1, 1);

    Map<DayOfWeek, Long> occurrences = new WeekDayCounter(startDate, endDate)
        .countWeekDaysForDayInMonth(13);

    List<Map.Entry<DayOfWeek, Long>> sortedOccurrences = occurrences.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.nullsLast(Long::compareTo)))
        .collect(Collectors.toList());

    String tableOfDays = sortedOccurrences.stream()
        .map(e -> String.format("%-12s %11d", getWeekDay(e), e.getValue()))
        .collect(Collectors.joining("\n"));

    log(String.format("Legend has it, "
            + "that the 13th day of the month falls more often on a Friday than any other day of the week.%n"
            + "%n"
            + "This Tool will now, for once and for all, summarize all the 13th from the %s to the %s.%n"
            + "The week days are ranked by their occurrences.%n"
            + "%n"
            + "DAY OF WEEK  OCCURRENCES%n"
            + "-----------  -----------%n"
            + "%s%n"
            + "%n"
            + "So in fact, the 13th day of the month falls most often on a %s.%n",
        startDate, endDate, tableOfDays, getWeekDay(sortedOccurrences.get(0))));
  }

  private static String getWeekDay(Map.Entry<DayOfWeek, Long> e) {
    return e.getKey().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
  }

  private static void log(String message) {
    System.out.println(message);
  }
}
