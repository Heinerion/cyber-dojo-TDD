package de.hsp.tdd.align_columns;

import java.util.*;

public class AlignColumns {
  private final String[] lines;
  private final String[][] wordTable;
  private final int[] column2width;

  private int maxCol;

  public AlignColumns(String source) {
    lines = source.split("\\n");
    wordTable = new String[lines.length][255];
    column2width = new int[255];

    maxCol = 0;
  }

  public String align() {
    analyzeLines();
    return formatLines();
  }

  private void analyzeLines() {
    for (int row = 0; row < lines.length; row++) {
      String[] words = lines[row].split("\\$");
      for (int column = 0; column < words.length; column++) {
        analyzeColumn(words[column], row, column);
      }
    }
  }

  private void analyzeColumn(String word, int row, int column) {
    column2width[column] = Math.max(word.length(), column2width[column]);
    wordTable[row][column] = word;

    maxCol = Math.max(column, maxCol);
  }

  private String formatLines() {
    List<String> formattedLines = new ArrayList<>();

    for (String[] row : wordTable) {
      formattedLines.add(formatLine(row, column2width, maxCol));
    }

    return String.join("\n", formattedLines);
  }

  private String formatLine(String[] row, int[] column2width, int maxCol) {
    List<String> line = new ArrayList<>();

    for (int column = 0; column <= maxCol; column++) {
      line.add(formatWord(row[column], column2width[column]));
    }

    return String.join(" ", line).trim();
  }

  private String formatWord(String word, int width) {
    String format = "%-" + width + "s";
    return String.format(format, Optional.ofNullable(word).orElse(""));
  }
}
