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

  public int getMinimum() {
    return stats.getMin();
  }
}
