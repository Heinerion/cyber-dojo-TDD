package de.hsp.tdd.calc_stats;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public final class Statistics {

  private final IntSummaryStatistics stats;

  private Statistics(IntSummaryStatistics stats) {
    this.stats = stats;
  }

  public static Statistics of(int... i) {
    return new Statistics(IntStream.of(i).summaryStatistics());
  }

  /**
   * @return the smallest number in the list of arguments or {@link Integer#MAX_VALUE}, if the given array was empty
   */
  public int getMinimum() {
    return stats.getMin();
  }

  /**
   * @return the greatest number in the list od arguments or {@link Integer#MIN_VALUE}, if the given array was empty
   */
  public int getMaximum() {
    return stats.getMax();
  }

  public int getNumberOfArguments() {
    return 0;
  }
}
