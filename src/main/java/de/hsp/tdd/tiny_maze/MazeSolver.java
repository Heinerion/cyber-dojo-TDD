package de.hsp.tdd.tiny_maze;

import java.util.Arrays;

public class MazeSolver {
  public String[][] solve(String[][] maze) {
    String[][] result = new String[maze.length][maze[0].length];
    for (String[] row : result) {
      Arrays.fill(row, "x");
    }
    return result;
  }
}
