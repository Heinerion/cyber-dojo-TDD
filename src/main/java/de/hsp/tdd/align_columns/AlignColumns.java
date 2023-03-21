package de.hsp.tdd.align_columns;

import java.util.*;

public class AlignColumns {
  /**
   * REGEX describing how lines in incoming text are separated
   */
  public static final String LINE_SEPARATOR_REGEX = "\\n";
  /**
   * Delimiter to separate lines in output
   */
  public static final String LINE_DELIMITER = "\n";

  /**
   * REGEX describing how word in a single line are separated in incoming text
   */
  public static final String WORD_SEPARATOR_REGEX = "\\$";
  /**
   * Delimiter to separate words in output
   */
  public static final String WORD_DELIMITER = " ";

  private final String[] lines;
  private final String[][] wordTable;
  private final int[] column2width;

  private int maxCol;

  public AlignColumns(String source) {
    lines = source.split(LINE_SEPARATOR_REGEX);
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
      String[] words = lines[row].split(WORD_SEPARATOR_REGEX);
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

    return String.join(LINE_DELIMITER, formattedLines);
  }

  private String formatLine(String[] row, int[] column2width, int maxCol) {
    List<String> line = new ArrayList<>();

    for (int column = 0; column <= maxCol; column++) {
      line.add(formatWord(row[column], column2width[column]));
    }

    return String.join(WORD_DELIMITER, line).trim();
  }

  private String formatWord(String word, int width) {
    String format = "%-" + width + "s";
    return String.format(format, Optional.ofNullable(word).orElse(""));
  }
}
