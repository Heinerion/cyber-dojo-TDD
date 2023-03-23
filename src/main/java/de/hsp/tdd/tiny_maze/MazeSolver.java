package de.hsp.tdd.tiny_maze;

import java.util.Arrays;

public class MazeSolver {
  public String[][] solve(String[][] maze) {
    String[][] result = new String[1][maze[0].length];
    Arrays.fill(result[0], "x");
    return result;
  }
}
