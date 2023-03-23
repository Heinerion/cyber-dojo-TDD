package de.hsp.tdd.tiny_maze;

public class MazeSolver {
  public String[][] solve(String[][] maze) {
    String[][] result = new String[maze.length][maze[0].length];
    for (int row = 0, resultLength = result.length; row < resultLength; row++) {
      for (int column = 0, rowLength = result[row].length; column < rowLength; column++) {
        String field = maze[row][column];
        if (field.equalsIgnoreCase("1")) {
          result[row][column] = field;
        } else {
          result[row][column] = "x";
        }
      }
    }
    return result;
  }
}
