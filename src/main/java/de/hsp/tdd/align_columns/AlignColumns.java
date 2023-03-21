package de.hsp.tdd.align_columns;

import java.util.*;

public class AlignColumns {
  public String align(String source) {
    String[] lines = source.split("\\n");
    String[][] wordTable = new String[lines.length][255];
    int[] column2width = new int[255];

    int maxCol = 0;

    for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
      String[] words = lines[lineNumber].split("\\$");
      for (int column = 0; column < words.length; column++) {
        String word = words[column];
        column2width[column] = Math.max(word.length(), column2width[column]);
        wordTable[lineNumber][column] = word;

        maxCol = Math.max(column, maxCol);
      }
    }

    return formatLines(wordTable, column2width, maxCol);
  }

  private String formatLines(String[][] wordTable, int[] column2width, int maxCol) {
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
