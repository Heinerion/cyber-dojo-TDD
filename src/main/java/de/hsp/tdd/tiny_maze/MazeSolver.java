package de.hsp.tdd.tiny_maze;

import java.util.*;

public class MazeSolver {

  public static final String START = "S";
  public static final String END = "E";
  public static final String WALL = "1";
  public static final String OPEN = "0";
  public static final String VISITED = "x";

  int maxY;
  int maxX;

  private String[][] workingCopy;
  boolean endReached = false;

  public String[][] solve(String[][] maze) {
    maxY = maze.length;
    maxX = maze[0].length;

    workingCopy = new String[maxY][maxX];
    for (int row = 0; row < maxY; row++) {
      workingCopy[row] = Arrays.copyOf(maze[row], maxX);
    }

    while (!endReached) {
      updateWorkingCopy();
    }

    return workingCopy;
  }

  private void updateWorkingCopy() {
    for (int row = 0; row < maxY; row++) {
      for (int col = 0; col < maxX; col++) {
        if (updateField(row, col)) {
          return;
        }
      }
    }
  }

  private boolean updateField(int row, int col) {
    String currentSymbol = workingCopy[row][col];
    if (currentSymbol.equalsIgnoreCase(WALL)
        || currentSymbol.equalsIgnoreCase(VISITED)) {
      return false;
    }

    if (currentSymbol.equalsIgnoreCase(START)) {
      workingCopy[row][col] = VISITED;
      return true;
    }

    List<String> neighbors = getNeighbors(row, col);
    if (neighbors.contains(VISITED)
        && (neighbors.contains(END) || neighbors.contains(OPEN))) {
      workingCopy[row][col] = VISITED;
      return true;
    }

    if (neighbors.contains(VISITED)
        && currentSymbol.equalsIgnoreCase(END)) {
      workingCopy[row][col] = VISITED;
      endReached = true;
      return true;
    }

    return false;
  }

  private List<String> getNeighbors(int row, int col) {
    List<String> neighbours = new ArrayList<>();
    getIfInBounds(row - 1, col).ifPresent(neighbours::add);
    getIfInBounds(row + 1, col).ifPresent(neighbours::add);
    getIfInBounds(row, col - 1).ifPresent(neighbours::add);
    getIfInBounds(row, col + 1).ifPresent(neighbours::add);
    return neighbours;
  }

  private Optional<String> getIfInBounds(int row, int col) {
    if (row < 0 || col < 0 || row >= maxY || col >= maxX) {
      return Optional.empty();
    }

    return Optional.of(workingCopy[row][col]);
  }
}
