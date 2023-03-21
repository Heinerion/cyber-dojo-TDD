package de.hsp.tdd.align_columns;

import java.util.*;

public class AlignColumns {
  public String align(String source) {
    String[] lines = source.split("\\n");
    String[][] wordMatrix = new String[lines.length][255];
    int[] column2width = new int[255];

    int maxCol = 0;

    for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
      String[] words = lines[lineNumber].split("\\$");
      for (int column = 0; column < words.length; column++) {
        String word = words[column];
        column2width[column] = Math.max(word.length(), column2width[column]);
        wordMatrix[lineNumber][column] = word;

        maxCol = Math.max(column, maxCol);
      }
    }

    List<String> formattedLines = new ArrayList<>();
    for (String[] matrix : wordMatrix) {
      StringBuilder lineBuilder = new StringBuilder();
      for (int column = 0; column <= maxCol; column++) {
        String word = matrix[column];
        String format = "%-" + column2width[column] + "s";
        lineBuilder.append(String.format(format, word == null ? "" : word));
        lineBuilder.append(" ");
      }
      formattedLines.add(lineBuilder.toString().trim());
    }

    return String.join("\n", formattedLines);
  }
}
